package com.immenser.interserv.services;

import com.immenser.interserv.models.*;
import com.immenser.interserv.repositories.GroupRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class GroupService {

    private final GroupRepository groupRepository;
    private final AgeService ageService;
    private final TicketService ticketService;
    private final JobService jobService;

    public void addGroup(Group group){
        groupRepository.save(group);
    }

    public Group findGroup(long id) {
        Optional<Group> optionalGroup = groupRepository.findById(id);
        return optionalGroup.orElseThrow();
    }

    public Group findGroupByEmployee(long employeeId) {
        Job job = jobService.findJobByEmployeeAndCurrentPeriod(employeeId);
        return groupRepository.findGroupByJobs(job);
    }

    public Group findGroupByChildAndPeriod(long childId, long periodId) {
        Ticket ticket = ticketService.findTicketByChildAndPeriod(childId, periodId);
        return groupRepository.findGroupByTickets(ticket);
    }

    public List<Group> findGroupsByPeriodAndAge(long periodId, long ageId) {
        Age age = ageService.findAge(ageId);
        List<Ticket> tickets = ticketService.findTicketsByPeriod(periodId);
        return groupRepository.findGroupsByTicketsAndAge(tickets, age);
    }

    public List<Group> findGroupsByPeriod(long periodId) {
        List<Ticket> tickets = ticketService.findTicketsByPeriod(periodId);
        return groupRepository.findGroupsByTickets(tickets);
    }

//    @Transactional
//    public void addProduct(AddProductRequest request) {
//        Cart cart = find(request.userId());
//        Product product = productService.findProduct(request.productId());
//        List<Product> products = cart.getProducts();
//        products.add(product);
//        cart.setProducts(products);
//        cartRepository.save(cart);
//    }


}
