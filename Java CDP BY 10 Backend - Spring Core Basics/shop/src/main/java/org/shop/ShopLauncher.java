package org.shop;

import org.shop.api.ItemService;
import org.shop.api.impl.ItemServiceImpl;
import org.shop.api.impl.UserServiceImpl;
import org.shop.repository.map.OrderMapRepository;
import org.shop.repository.map.SellerMapRepository;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


/**
 * The ShopLauncher class.
 */
public class ShopLauncher {
    
    private static ApplicationContext applicationContext = 
    		new ClassPathXmlApplicationContext("spring.xml");;

	/**
     * The main method.
     *
     * @param args the arguments
     */
	public static void main(String[] args) {

		ItemService service = 
				(ItemServiceImpl) applicationContext.getBean("org.shop.api.impl.ItemServiceImpl");
		
		OrderMapRepository orderMapRepository = 
				(OrderMapRepository) applicationContext.getBean(OrderMapRepository.class);
		
		SellerMapRepository sellerMapRepository = (SellerMapRepository) applicationContext
				.getBean("org.shop.repository.map.SellerMapRepository", SellerMapRepository.class);
		
		UserServiceImpl userServiceImpl = (UserServiceImpl) applicationContext
				.getBean("userService", UserServiceImpl.class);

    }

}
