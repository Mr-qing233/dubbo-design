package org.example.service;

import org.apache.dubbo.config.annotation.DubboService;
import org.example.entity.Borrow;
import org.example.exception.ServiceException;
import org.example.repository.BookRepository;
import org.example.repository.BorrowRepository;
import org.example.vo.ResultEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.text.SimpleDateFormat;
import java.util.*;

@DubboService
public class BorrowServiceImpl implements BorrowService{
    @Autowired
    private BorrowRepository borrowRepository;

    @Autowired
    private BookRepository bookRepository;

    /**
     * 根据Bid与Uid搜索借阅记录
     *
     * @param bid 书籍id
     * @param uid 用户id
     * @return List
     */
    @Override
    public List<Borrow> searchBookByBidAndUid(String bid, String uid) {
        List<Borrow> borrow = borrowRepository.findBorrowByBidAndUid(bid, uid);
        if (borrow == null){
            throw new ServiceException(ResultEnum.SEARCHNOTFOUND);
        }
        return borrow;
    }

    /**
     * 根据bid搜索特定记录
     *
     * @param bid 书籍id
     */
    @Override
    public List<Borrow> searchBookByBid(String bid) {
        List<Borrow> borrow = borrowRepository.findBorrowByBid(bid);
        if (borrow == null){
            throw new ServiceException(ResultEnum.SEARCHNOTFOUND);
        }
        return borrow;
    }

    /**
     * 根据uid搜索特定记录
     *
     * @param uid 用户id
     */
    @Override
    public List<Borrow> searchBookByUid(String uid) {
        List<Borrow> borrow = borrowRepository.findBorrowByUid(uid);
        if (borrow == null){
            throw new ServiceException(ResultEnum.SEARCHNOTFOUND);
        }
        return borrow;
    }

    /**
     * 检索未归还书籍
     * 若没有未归还应该为true
     * @param bid 书籍id
     * @param uid 用户id
     * @return Borrow
     */
    @Override
    public boolean searchNotReturnedBook(String bid, String uid) {
        Borrow state = borrowRepository.findBorrowByBidAndUidAndState(bid, uid, 0);
        return state == null;
    }

    /**
     * @param borrowId 借阅id
     * @return Borrow
     */
    @Override
    public HashMap<String,String > searchIdsByBorrowId(Integer borrowId) {
        Borrow borrow = borrowRepository.findBorrowByBorrowId(borrowId);
        if (borrow == null){
            throw new ServiceException(ResultEnum.SEARCHNOTFOUND);
        }
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("uid",borrow.getUid());
        hashMap.put("bid",borrow.getBid());
        return hashMap;
    }


    /**
     * 添加借阅记录
     *
     * @param borrow Borrow
     * @return boolean
     */
    @Override
    @Transactional
    public boolean addRecord(Borrow borrow) {
        // 检查实体完整性
        if((borrow.getBid() == null) && (borrow.getUid() == null)){
            throw new ServiceException(ResultEnum.MISSINGPARAMS);
        }
        // 检查属性值
        if(borrow.getState() != 0){
            throw new ServiceException(ResultEnum.PARAMSDOMAINERROR);
        }
        // 检查是否有未归还的相同书籍
        if (!searchNotReturnedBook(borrow.getBid(),borrow.getUid())){
            throw new ServiceException(ResultEnum.HAVENOTRETURNED);
        }
        // 增加借阅信息
        // 补完时间信息
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        borrow.setBDate(format.format(new Date()));
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DATE,30);
        borrow.setRDate(format.format(cal.getTime()));
        // 减少库存
        if(bookRepository.decreaseStock(borrow.getBid(),1).equals(0)){
            throw new ServiceException(ResultEnum.DECREASEFAILED);
        }
        // 新增借阅
        if (borrowRepository.addNewRecord(borrow).equals(0)){
            throw new ServiceException(ResultEnum.BORROWFAILED);
        }
        // 返回bool值
        return true;
    }

    /**
     * 还书
     * @param borrowId 借阅
     * @return boolean
     */
    @Override
    @Transactional
    public boolean returnRecord(Integer borrowId) {
        // 修改借阅状态
        if (borrowRepository.alterRecordState(borrowId).equals(0)){
            throw new ServiceException(ResultEnum.RETURNFAILED);
        }
        HashMap<String, String> hashMap = searchIdsByBorrowId(borrowId);
        // 增加库存
        if(bookRepository.increaseStock(hashMap.get("bid"),1).equals(0)){
            throw new ServiceException(ResultEnum.INCREASEFAILED);
        }
        // 返回bool值
        return true;
    }
}
