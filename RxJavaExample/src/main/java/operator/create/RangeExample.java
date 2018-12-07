package operator.create;

import io.reactivex.Observable;
import io.reactivex.functions.Predicate;

public class RangeExample {

	/*
	 * n���� m���� integer ��ü�� ����
	 */

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Observable<Integer> observable = Observable.range(1, 10).filter(number ->{ return number%2 == 0;});
		observable.subscribe(System.out::println);

	}

}
