package menu;

import java.util.List;
import java.util.Scanner;

import car.pojo.Car;
import car.service.CarServiceIMP;
import order.pojo.Order;
import order.service.OrderServiceIMP;
import product.pojo.Product;
import product.service.ProductServiceIMP;
import user.service.UserServieIMP;

public class Menu {
	public static void main(String[] args) throws Exception {
		
		UserServieIMP userServieIMP = new UserServieIMP();
		ProductServiceIMP productServiceIMP = new ProductServiceIMP();
		OrderServiceIMP orderServiceIMP = new OrderServiceIMP();
		CarServiceIMP carServiceIMP = new CarServiceIMP();
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);

		System.out.println("欢迎你的到来");
		boolean flage = true;
		while(flage) {
			System.out.println("1.注册  2.登录  3.退出");
			String firest_command = scanner.nextLine();
			switch (firest_command) {
			case "1":
				System.out.println("请输入用户名：");
				String register_account = scanner.nextLine();
				
				System.out.println("请输入姓名：");
				String name = scanner.nextLine();
				
				System.out.println("请输入第一次密码：");
				String password1 = scanner.nextLine();
				
				System.out.println("请输入第二次密码：");
				String password2 = scanner.nextLine();
				
				System.out.println("请输入年龄：");
				int age = scanner.nextInt();
				
				System.out.println("请输入手机号：");
				String phone = scanner.nextLine();
				
				System.out.println("请输入地址：");
				String addr = scanner.nextLine();
				
				boolean register = userServieIMP.register(register_account, name, password1, password2, age, phone, addr);
				if (register) {
					System.out.println("恭喜你注册成功！");
				}else {
					System.out.println("抱歉，注册失败，请重新注册！");
				}
				break;
			
			case "2":
				System.out.println("请输入你的用户名:");
				String account = scanner.nextLine();
				System.out.println("请输入你的密码:");
				String passwd = scanner.nextLine();
				boolean login = userServieIMP.login(account, passwd);
				if (login) {
					boolean u_flage = true;
					while(u_flage) {
						System.out.println("1.查看所有商品  2.通过分类查看商品  3.通过价格获得商品  4.通过id获得商品  5.开始购物  6.退出  ");
						String command = scanner.nextLine();
						switch (command) {
						case "1":
							List<Product> allProducts = productServiceIMP.getAllProducts();
							for(Product tmp:allProducts) {
								System.out.println(tmp);
							}
							break;
							
						case "2":
							System.out.println("请输入分类名:");
							String categoryName = scanner.nextLine();
							List<Product> productByCategoryName = productServiceIMP.getProductByCategoryName(categoryName);
							for(Product tmp:productByCategoryName) {
								System.out.println(tmp);
							}
							break;
							
						case "3":
							System.out.println("请输入商品的最小价格:");
							float minPrice = scanner.nextFloat();
							System.out.println("请输入商品的最大价格:");
							float maxPrice = scanner.nextFloat();
							List<Product> productsByPrice = productServiceIMP.getProductsByPrice(minPrice, maxPrice);
							for(Product tmp:productsByPrice) {
								System.out.println(tmp);
							}
							break;
						
						case "4":
							System.out.println("请输入商品的id:");
							String id = scanner.nextLine();
							Product productById = productServiceIMP.getProductById(id);
							System.out.println(productById);
							break;
							
						case "6":
							u_flage = false;
							System.out.println("欢迎下次再来！");
							break;
						
						case "5":
							boolean shop_flage = true;
							while(shop_flage) {
								System.out.println("1.添加商品到购物车  2.从购物车中删除商品  3.查看购物车中的所有商品  4.通过id获得商品 5.修改购物车的数量  6. 提交订单  7.退出");
								String shop_comman = scanner.nextLine();
								switch (shop_comman) {
								case "1":
									System.out.println("请分别输入用户名,商品id,商品数量");
									String uaccount_id_num = scanner.nextLine();
									String[] info = uaccount_id_num.split(",");
									boolean addProduct = carServiceIMP.addProduct(info[0], info[1], Integer.parseInt(info[2]));
									if (addProduct) {
										System.err.println("加入购物车成功！");
									}else {
										System.out.println("加入购物车失败。。。");
									}
									break;
								
								case "2":
									System.out.println("请输入用户名：");
									String u_tow_account = scanner.nextLine();
									System.out.println("请输入商品的id：");
									String u_tow_pid = scanner.nextLine();
									boolean removeProduct = carServiceIMP.removeProduct(u_tow_account, u_tow_pid);
									if (removeProduct) {
										System.out.println("修改成功！");
									}else {
										System.out.println("修改失败...");
									}
									break;
								
								case "3":
									List<Car> allProductFromCar = carServiceIMP.getAllProductFromCar();
									for(Car tmp:allProductFromCar) {
										System.out.println(tmp);
									}
									break;
								
								case "4":
									System.out.println("请输入商品的id：");
									String four_id = scanner.nextLine();
									Product aProduct = carServiceIMP.getAProduct(four_id);
									System.out.println(aProduct);
									break;
								
								case "5":
									System.out.println("请输入用户名：");
									String five_account = scanner.nextLine();
									System.err.println("请输入商品的id");
									String five_id = scanner.nextLine();
									System.out.println("请输入修改后的商品数量：");
									int five_num = scanner.nextInt();
									boolean changeProductInCar = carServiceIMP.changeProductInCar(five_account, five_id, five_num);
									if (changeProductInCar) {
										System.out.println("恭喜你，修改成功！");
									}else {
										System.out.println("对不起，修改失败。");
									}
									break;

								case "7":
									System.out.println("欢迎下次再来！");
									shop_flage = false;
									break;
								
								case "6":
									boolean order_flage = true;
									while(order_flage) {
										System.out.println("1.查看所有订单  2.查找一个订单  3.修改订单  4.退出");
										String order_command = scanner.nextLine();
										switch (order_command) {
										case "1":
											List<Order> allOrder = orderServiceIMP.getAllOrder();
											for(Order tmp:allOrder) {
												System.out.println(tmp);
											}
											break;
										case "2":
											System.out.println("请输入一个订单号：");
											String oid = scanner.nextLine();
											Order orderByOid = orderServiceIMP.getOrderByOid(oid);
											System.out.println(orderByOid);
											break;
										
										case "3":
											System.out.println("请输入oid：");
											String oid_three = scanner.nextLine();
											System.out.println("请分别输入用户名,商品名,数量,电话,地址");
											String info_order = scanner.nextLine();
											String[] strings = info_order.split(",");
											boolean changeOrder = orderServiceIMP.changeOrder(oid_three, strings[1], Integer.parseInt(strings[2]), strings[3], strings[4]);
											if (changeOrder) {
												System.out.println("恭喜你，修改成功！");
											}else {
												System.out.println("对不起，修改失败。");
											}
											break;
										
										case "4":
											System.out.println("正在退出，请稍后。。。");
											order_flage = false;
											break;
										default:
											System.out.println("输入有误，请重新输入！");
											break;
										}
									}
									break;
								default:
									System.out.println("你的输入有误，请重新输入。");
									break;
								}
							}
							break;
						default:
							
							System.out.println("你输入的有误，请重新输入：");
							break;
						}
					}
				}
			case "3":
				flage = false;
				System.out.println("正在退出....");
			default:
				System.out.println("你输入的有误，请重新输入。");
				break;
			}	
			
		}
	}
}
