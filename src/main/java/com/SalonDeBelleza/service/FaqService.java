/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.SalonDeBelleza.service;

import com.SalonDeBelleza.entity.Comentario;
import com.SalonDeBelleza.entity.Faq;
import com.SalonDeBelleza.repository.FaqRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author María José
 */
@Service
public class FaqService implements IFaqService {

    @Autowired
    private FaqRepository faqRepository;

    @Override
    public List<Faq> getAllFaq() {
        return (List<Faq>) faqRepository.findAll();
    }

    @Override
    public Faq getFaqByID(long ID_faq) {
        return faqRepository.findById(ID_faq).orElse(null);
    }

    @Override
    public void saveFaq(Faq faq) {
        faqRepository.save(faq);
    }

    @Override
    public void delete(long ID_faq) {
        faqRepository.deleteById(ID_faq);
    }

}
