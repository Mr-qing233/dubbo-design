package org.example.service;

import org.apache.dubbo.config.annotation.DubboService;
import org.example.entity.Storage;
import org.example.exception.ServiceException;
import org.example.repository.BookRepository;
import org.example.repository.StorageRepository;
import org.example.vo.ResultEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@DubboService
public class StorageServiceImpl implements StorageService{

    @Autowired
    private StorageRepository storageRepository;

    @Autowired
    private BookRepository bookRepository;


    /**
     * 仅仅增加库存记录，不修改book
     * @param bid 书籍id
     * @param count 增减数量
     * @return boolean
     */
    @Override
    public boolean addStorage(String uid,String bid, Integer count) {
        Integer storage = storageRepository.addStorageRecord(uid,bid,count);
        if (storage == 0){
            throw new ServiceException(ResultEnum.ADDSTORAGEFAILED);
        }
        return true;
    }

    /**
     * 增加库存同时修改book库存
     * @param uid 用户id
     * @param bid 书籍id
     * @param count 数量
     * @return boolean
     */
    @Transactional
    @Override
    public boolean newStorage(String uid,String bid, Integer count) {
        if (count == 0){
            throw new ServiceException(ResultEnum.ALTERCANNOTZERO);
        }
        if ((count < 0) && (-count > bookRepository.findBookByBid(bid).getStockQuantity())){
            throw new ServiceException(ResultEnum.STOCKNOTENOUGH);
        }
        if (storageRepository.addStorageRecord(uid,bid,count) == 0){
            throw new ServiceException(ResultEnum.ADDSTORAGEFAILED);
        }
        if (bookRepository.alterBookNumber(bid, count) == 0){
            throw new ServiceException(ResultEnum.ALTERFAILED);
        }
        return true;
    }

    /**
     * 展示所有记录
     * @return List
     */
    @Override
    public List<Storage> showAll() {
        return storageRepository.findAll();
    }
}
