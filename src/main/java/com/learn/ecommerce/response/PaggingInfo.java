package com.learn.ecommerce.response;

import java.util.List;
import org.springframework.data.domain.Page;
import lombok.Data;

@Data
public class PaggingInfo<T> {
   public Integer currentPage;
   public Integer nextPage;
    public Integer prevPage;
    public Integer totalPage;
    public Long totalItems;
    public List<T> contents;

   public static <T> PaggingInfo<T> convertFromPage(Page<T> page) {
        PaggingInfo<T> paggingInfo = new PaggingInfo<>();
        paggingInfo.currentPage = page.getNumber() + 1;
        paggingInfo.totalPage = page.getTotalPages();
        paggingInfo.totalItems = page.getTotalElements();
        if(page.hasNext()) {
            paggingInfo.nextPage =( page.getNumber() + 1)+1;
        }
        if(page.hasPrevious()) {
            if(paggingInfo.currentPage > paggingInfo.totalPage) {
                paggingInfo.prevPage = paggingInfo.totalPage;
            }else{
                paggingInfo.prevPage = (page.getNumber() - 1) - 1;
            }
            
        }
      
        paggingInfo.contents = page.getContent();
     
        return paggingInfo;
    }


}
