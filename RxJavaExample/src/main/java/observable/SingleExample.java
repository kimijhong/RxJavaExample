package observable;

import comm.Order;
import io.reactivex.Observable;
import io.reactivex.Single;

public class SingleExample {

	/**
	 * ���� 1���� �����͸� �����ϵ��� ����
	 */
	public static void main(String[] args) {
		
		Single<String> single = Single.just("Hello Single");
		single.subscribe(System.out::println);
		
		//���� Observable���� Single ��ü ��ȯ just�� �������� ���� ����
		Observable<String> source = Observable.just("Observable to single");
		Single.fromObservable(source)
		.doOnError(err->{System.out.println(err.getMessage());})
		.subscribe(data->{System.out.println(data);});
		
		//�̱��Լ��� �̿��� single ��ü ����
		Observable.just("single() �Լ��̿�").single("default item").subscribe(System.out::println);
		
		//first()�Լ��� ȣ���� single ��ü ����
		String colors[] = {"red","blue","black"};
		Observable.fromArray(colors)
		.first("default value")
		.subscribe(System.out::println);
		
		//empty ���� single ��ü ����
		Observable.empty()
		.single("default value")
		.subscribe(System.out::println);
		
		//take() �Լ����� single ��ü ����
		Observable.just(new Order("item-1"),new Order("item-2"))
		.take(1)
		.single(new Order("default order"))
		.subscribe(data->{
			System.out.println(data.getId());
		});
		
		
		//�̱�Ŭ���� �����͸� �ϳ��� �����Ҽ� �ֵ��� �Ѵ�. �������� �����Ұ�� ���� �����߻��ñ�� �����͸� ����
		Observable.just("Hello Single","error")
		.single("default item")
		.subscribe(System.out::println,
				err->{
					System.out.println("�����޼��� : " + err.getMessage());
					System.out.println("����ó��");
		});
		

	}

}
