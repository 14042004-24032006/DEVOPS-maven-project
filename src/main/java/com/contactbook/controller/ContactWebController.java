package com.contactbook.controller;

import com.contactbook.entity.Contact;
import com.contactbook.repository.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class ContactWebController {

    @Autowired
    private ContactRepository contactRepository;

    @GetMapping("/")
    public String viewHome(Model model) {
        model.addAttribute("contacts", contactRepository.findAll());
        return "index";
    }

    @GetMapping("/contacts/new")
    public String addContactForm(Model model) {
        model.addAttribute("contact", new Contact());
        return "contact-form";
    }

    @GetMapping("/contacts/edit/{id}")
    public String editContactForm(@PathVariable Long id, Model model) {
        Contact contact = contactRepository.findById(id).orElse(null);
        model.addAttribute("contact", contact);
        return "contact-form";
    }

    @PostMapping("/contacts/save")
    public String saveContact(@ModelAttribute Contact contact) {
        contactRepository.save(contact);
        return "redirect:/";
    }

    @GetMapping("/contacts/delete/{id}")
    public String deleteContact(@PathVariable Long id) {
        contactRepository.deleteById(id);
        return "redirect:/";
    }
}
