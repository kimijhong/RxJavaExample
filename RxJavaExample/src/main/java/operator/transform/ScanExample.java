package operator.transform;

import io.reactivex.Observable;

public class ScanExample {
	
	public void emit()
	{
		
		/**
		 * reduce�� ���� ������ ��� ���� 
		 */
		String[] balls = {"1","3","5","6"};
		Observable<String> observable = Observable.fromArray(balls).scan((data1,data2)->{
			return  data1 + data2;
		});
		observable.subscribe(System.out::println);
		
		
	}

	
	public static void main(String[] args) {

		new ScanExample().emit();
	}


}
