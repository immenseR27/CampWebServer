package com.immenser.interserv.services;

import com.immenser.interserv.models.Employee;
import com.immenser.interserv.models.Group;
import com.immenser.interserv.repositories.GroupRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GroupService {
    private final GroupRepository groupRepository;
    private final EmployeeService employeeService;

//    @Transactional
//    public void addProduct(AddProductRequest request) {
//        Cart cart = find(request.userId());
//        Product product = productService.findProduct(request.productId());
//        List<Product> products = cart.getProducts();
//        products.add(product);
//        cart.setProducts(products);
//        cartRepository.save(cart);
//    }

//    public Group find(Long userId) {
//        Employee employee = employeeService.findUser(userId);
//        return groupRepository.findByUser(employee);
//    }
}
