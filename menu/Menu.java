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

		System.out.println("��ӭ��ĵ���");
		boolean flage = true;
		while(flage) {
			System.out.println("1.ע��  2.��¼  3.�˳�");
			String firest_command = scanner.nextLine();
			switch (firest_command) {
			case "1":
				System.out.println("�������û�����");
				String register_account = scanner.nextLine();
				
				System.out.println("������������");
				String name = scanner.nextLine();
				
				System.out.println("�������һ�����룺");
				String password1 = scanner.nextLine();
				
				System.out.println("������ڶ������룺");
				String password2 = scanner.nextLine();
				
				System.out.println("���������䣺");
				int age = scanner.nextInt();
				
				System.out.println("�������ֻ��ţ�");
				String phone = scanner.nextLine();
				
				System.out.println("�������ַ��");
				String addr = scanner.nextLine();
				
				boolean register = userServieIMP.register(register_account, name, password1, password2, age, phone, addr);
				if (register) {
					System.out.println("��ϲ��ע��ɹ���");
				}else {
					System.out.println("��Ǹ��ע��ʧ�ܣ�������ע�ᣡ");
				}
				break;
			
			case "2":
				System.out.println("����������û���:");
				String account = scanner.nextLine();
				System.out.println("�������������:");
				String passwd = scanner.nextLine();
				boolean login = userServieIMP.login(account, passwd);
				if (login) {
					boolean u_flage = true;
					while(u_flage) {
						System.out.println("1.�鿴������Ʒ  2.ͨ������鿴��Ʒ  3.ͨ���۸�����Ʒ  4.ͨ��id�����Ʒ  5.��ʼ����  6.�˳�  ");
						String command = scanner.nextLine();
						switch (command) {
						case "1":
							List<Product> allProducts = productServiceIMP.getAllProducts();
							for(Product tmp:allProducts) {
								System.out.println(tmp);
							}
							break;
							
						case "2":
							System.out.println("�����������:");
							String categoryName = scanner.nextLine();
							List<Product> productByCategoryName = productServiceIMP.getProductByCategoryName(categoryName);
							for(Product tmp:productByCategoryName) {
								System.out.println(tmp);
							}
							break;
							
						case "3":
							System.out.println("��������Ʒ����С�۸�:");
							float minPrice = scanner.nextFloat();
							System.out.println("��������Ʒ�����۸�:");
							float maxPrice = scanner.nextFloat();
							List<Product> productsByPrice = productServiceIMP.getProductsByPrice(minPrice, maxPrice);
							for(Product tmp:productsByPrice) {
								System.out.println(tmp);
							}
							break;
						
						case "4":
							System.out.println("��������Ʒ��id:");
							String id = scanner.nextLine();
							Product productById = productServiceIMP.getProductById(id);
							System.out.println(productById);
							break;
							
						case "6":
							u_flage = false;
							System.out.println("��ӭ�´�������");
							break;
						
						case "5":
							boolean shop_flage = true;
							while(shop_flage) {
								System.out.println("1.�����Ʒ�����ﳵ  2.�ӹ��ﳵ��ɾ����Ʒ  3.�鿴���ﳵ�е�������Ʒ  4.ͨ��id�����Ʒ 5.�޸Ĺ��ﳵ������  6. �ύ����  7.�˳�");
								String shop_comman = scanner.nextLine();
								switch (shop_comman) {
								case "1":
									System.out.println("��ֱ������û���,��Ʒid,��Ʒ����");
									String uaccount_id_num = scanner.nextLine();
									String[] info = uaccount_id_num.split(",");
									boolean addProduct = carServiceIMP.addProduct(info[0], info[1], Integer.parseInt(info[2]));
									if (addProduct) {
										System.err.println("���빺�ﳵ�ɹ���");
									}else {
										System.out.println("���빺�ﳵʧ�ܡ�����");
									}
									break;
								
								case "2":
									System.out.println("�������û�����");
									String u_tow_account = scanner.nextLine();
									System.out.println("��������Ʒ��id��");
									String u_tow_pid = scanner.nextLine();
									boolean removeProduct = carServiceIMP.removeProduct(u_tow_account, u_tow_pid);
									if (removeProduct) {
										System.out.println("�޸ĳɹ���");
									}else {
										System.out.println("�޸�ʧ��...");
									}
									break;
								
								case "3":
									List<Car> allProductFromCar = carServiceIMP.getAllProductFromCar();
									for(Car tmp:allProductFromCar) {
										System.out.println(tmp);
									}
									break;
								
								case "4":
									System.out.println("��������Ʒ��id��");
									String four_id = scanner.nextLine();
									Product aProduct = carServiceIMP.getAProduct(four_id);
									System.out.println(aProduct);
									break;
								
								case "5":
									System.out.println("�������û�����");
									String five_account = scanner.nextLine();
									System.err.println("��������Ʒ��id");
									String five_id = scanner.nextLine();
									System.out.println("�������޸ĺ����Ʒ������");
									int five_num = scanner.nextInt();
									boolean changeProductInCar = carServiceIMP.changeProductInCar(five_account, five_id, five_num);
									if (changeProductInCar) {
										System.out.println("��ϲ�㣬�޸ĳɹ���");
									}else {
										System.out.println("�Բ����޸�ʧ�ܡ�");
									}
									break;

								case "7":
									System.out.println("��ӭ�´�������");
									shop_flage = false;
									break;
								
								case "6":
									boolean order_flage = true;
									while(order_flage) {
										System.out.println("1.�鿴���ж���  2.����һ������  3.�޸Ķ���  4.�˳�");
										String order_command = scanner.nextLine();
										switch (order_command) {
										case "1":
											List<Order> allOrder = orderServiceIMP.getAllOrder();
											for(Order tmp:allOrder) {
												System.out.println(tmp);
											}
											break;
										case "2":
											System.out.println("������һ�������ţ�");
											String oid = scanner.nextLine();
											Order orderByOid = orderServiceIMP.getOrderByOid(oid);
											System.out.println(orderByOid);
											break;
										
										case "3":
											System.out.println("������oid��");
											String oid_three = scanner.nextLine();
											System.out.println("��ֱ������û���,��Ʒ��,����,�绰,��ַ");
											String info_order = scanner.nextLine();
											String[] strings = info_order.split(",");
											boolean changeOrder = orderServiceIMP.changeOrder(oid_three, strings[1], Integer.parseInt(strings[2]), strings[3], strings[4]);
											if (changeOrder) {
												System.out.println("��ϲ�㣬�޸ĳɹ���");
											}else {
												System.out.println("�Բ����޸�ʧ�ܡ�");
											}
											break;
										
										case "4":
											System.out.println("�����˳������Ժ󡣡���");
											order_flage = false;
											break;
										default:
											System.out.println("�����������������룡");
											break;
										}
									}
									break;
								default:
									System.out.println("��������������������롣");
									break;
								}
							}
							break;
						default:
							
							System.out.println("��������������������룺");
							break;
						}
					}
				}
			case "3":
				flage = false;
				System.out.println("�����˳�....");
			default:
				System.out.println("��������������������롣");
				break;
			}	
			
		}
	}
}
