package com.SalonDeBelleza.service;


import com.SalonDeBelleza.entity.Faq;
import java.util.List;

/**
 *
 * @author María José
 */
public interface IFaqService {

    public List<Faq> getAllFaq();

    public Faq getFaqByID(long ID_faq);

    public void saveFaq(Faq faq);

    public void delete(long ID_faq);
}
