package com.poecat.housepaintingadmin.controller;

import com.poecat.housepaintingadmin.exception.CommissionNotFoundException;
import com.poecat.housepaintingadmin.model.Client;
import com.poecat.housepaintingadmin.model.Commission;
import com.poecat.housepaintingadmin.repository.ClientRepository;
import com.poecat.housepaintingadmin.service.CommissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class CommissionController {

    @Autowired
    private CommissionService commissionService;
    @Autowired
    private ClientRepository clientRepository;


    @RequestMapping("/commissions")
    public String viewCommissionsPage(Model model) {
        List<Commission> listCommissions = commissionService.listAll();
        model.addAttribute("listCommissions", listCommissions);

        return "commissions";
    }

    @RequestMapping("/commissions/new")
    public String showNewCommissionPage(Model model) {
        List<Client> clientsList = clientRepository.findAll();

        model.addAttribute("commission", new Commission());
        model.addAttribute("clientsList", clientsList);

        model.addAttribute("pageTitle", "Add new commission");

        return "new_commission";
    }

    @RequestMapping(value = "/commissions/save", method = RequestMethod.POST)
    public String saveCommission(@ModelAttribute("commission") Commission commission, RedirectAttributes re) {
        commissionService.save(commission);
        re.addFlashAttribute("message", "Commission has been saved successfully.");

        return "redirect:/commissions";
    }

    @RequestMapping("/commissions/edit/{id}")
    public String showEditCommissionPage(@PathVariable(name = "id") Integer id,
                                         Model model, RedirectAttributes re) {
        try {
            List<Client> clientsList = clientRepository.findAll();
            Commission commission = commissionService.get(id);
            model.addAttribute("commission", commission);
            model.addAttribute("clientsList", clientsList);
            model.addAttribute("pageTitle", "Edit commission (ID: " + id + ")");
            return "edit_commission";
        } catch (CommissionNotFoundException e) {
            re.addFlashAttribute("message", e.getMessage());

            return "redirect:/commissions";
        }
    }

    @RequestMapping("/commissions/delete/{id}")
    public String deleteCommission(@PathVariable(name = "id") Integer id, RedirectAttributes re) {
        try {
            commissionService.delete(id);
            re.addFlashAttribute("message", "The commission with ID: " + id + " has been deleted.");
        } catch (CommissionNotFoundException e) {
            re.addFlashAttribute("message", e.getMessage());
        }
        return "redirect:/commissions";
    }

}
