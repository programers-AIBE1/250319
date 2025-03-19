package org.example.t250319.controller;

import org.example.t250319.model.dto.ConcertDTO;
import org.example.t250319.model.dto.TicketDTO;
import org.example.t250319.model.dto.UserDTO;
import org.example.t250319.model.repository.ConcertRepository;
import org.example.t250319.model.repository.TicketRepository;
import org.example.t250319.model.repository.UserRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.UUID;
import java.util.logging.Logger;

@Controller
@RequestMapping("/")
public class MainController {


    final private Logger logger = Logger.getLogger(MainController.class.getName());
    final private UserRepository userRepository;
    final private ConcertRepository concertRepository;
    private final TicketRepository ticketRepository;

    public MainController(UserRepository userRepository, ConcertRepository concertRepository, TicketRepository ticketRepository) {
        this.userRepository = userRepository;
        this.concertRepository = concertRepository;
        this.ticketRepository = ticketRepository;
    }

    @RequestMapping("/")
    String index(Model model) throws Exception {
        model.addAttribute("users", userRepository.findAll());
        model.addAttribute("concerts", concertRepository.findAll());
        model.addAttribute("tickets", ticketRepository.findAll());
        return "index";
    }

    @PostMapping("/user")
    String addUser(@ModelAttribute UserDTO userDTO) throws Exception {
        logger.info("Adding user: " + userDTO);
        userRepository.save(new UserDTO(
                UUID.randomUUID().toString(),
                userDTO.name(),
                userDTO.email(),
                userDTO.phone()
        ));
        return "redirect:/";
    }

    @PostMapping("/concert")
        // form을 사용한 POST 요청은 ModelAttribute
    String addConcert(@ModelAttribute ConcertDTO concertDTO) throws Exception {
        logger.info("Adding concert: " + concertDTO);
        concertRepository.save(new ConcertDTO(
                UUID.randomUUID().toString(),
                concertDTO.title(),
                concertDTO.date(),
                concertDTO.location()
        ));
        return "redirect:/";
    }

    @PostMapping("/ticket")
        // form을 사용한 POST 요청은 ModelAttribute
    String addTicket(@ModelAttribute TicketDTO ticketDTO) throws Exception {
        logger.info("Adding ticket: " + ticketDTO);
        if (concertRepository.findById(ticketDTO.concertId()) == null) {
            throw new Exception("Concert does not exist");
        }
        if (userRepository.findById(ticketDTO.userId()) == null) {
            throw new Exception("User does not exist");
        }
        ticketRepository.save(new TicketDTO(
                UUID.randomUUID().toString(),
                ticketDTO.seatNumber(),
                ticketDTO.price(),
                ticketDTO.purchaseDate(),
                ticketDTO.concertId(),
                ticketDTO.userId()
        ));
        return "redirect:/";
    }


}


