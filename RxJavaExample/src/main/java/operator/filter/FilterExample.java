package operator.filter;
import comm.CommUtil;
import io.reactivex.Observable;
import io.reactivex.Single;
import io.reactivex.functions.Action;

public class FilterExample {
	
	
	

	public void emit() {
		
		Integer numbers[] = {100,200,300,400,500};
		Single<Integer> single;
		Observable<Integer> observable;
		
		
		//ù��° ���� ���� ������ �⺻�� -1
		single = Observable.fromArray(numbers)
				.first(-1);
		single.subscribe(System.out::println).dispose();
		
		CommUtil.exampleComplete();
	
		
		//�������� ������ �⺻�� -1
		single = Observable.fromArray(numbers)
				.last(-1);
		single.subscribe(System.out::println);
		
		
		CommUtil.exampleComplete();
		
		//ù��°���� n��
		observable = Observable.fromArray(numbers)
				.take(3);
		observable.subscribe(System.out::println);
		CommUtil.exampleComplete();
		
		//n���� ����������
		observable = Observable.fromArray(numbers)
				.takeLast(3);
		observable.subscribe(System.out::println);
		CommUtil.exampleComplete();
		
		//n���� �ǳʶ�� ����������
		observable = Observable.fromArray(numbers)
				.skip(3);
		observable.subscribe(System.out::println);
		CommUtil.exampleComplete();
		
		
		//���������� n���� �ǳʶ�� ó�ݰ�����
		observable = Observable.fromArray(numbers)
				.skipLast(2);
		observable.subscribe(System.out::println);
	}

	public static void main(String[] args) {

		new FilterExample().emit();
	}

}
