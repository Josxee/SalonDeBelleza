package com.SalonDeBelleza.service;

import com.SalonDeBelleza.entity.Comentario;
import com.SalonDeBelleza.entity.Faq;
import java.util.List;

/**
 *
 * @author María José
 */
public interface IFaqService {

    public List<Faq> getAllFaq();

    public Faq getFaqByID(long id);

    public void saveFaq(Faq faq);

    public void delete(long id);
}
