package observable;

import java.lang.reflect.Array;
import java.util.ArrayList;

import comm.CommUtil;
import io.reactivex.Observable;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;

public class ObservableFromArray {

	Action onCompleteAction = () -> {
		System.out.println("---------------¿Ï·á----------------");
	};

	public void array() {
		Integer arr[] = { 999, 888, 777 };

		Observable<Integer> source = Observable.fromArray(arr).doOnComplete(onCompleteAction);

		source.subscribe((v) -> {
			System.out.println(v);
		});

	
	}
	
	public void arrayIntWorng()
	{
		int intArr[] = { 88, 77, 66 };

		Observable.fromArray(intArr).doOnComplete(onCompleteAction)
				.subscribe(System.out::println);
	
	}
	
	public void arrayInt()
	{
		int intArr[] = { 88, 77, 66 };

		Observable.fromArray(CommUtil.toIntegerArray(intArr)).doOnComplete(onCompleteAction)
				.subscribe(System.out::println);
		
	}

	public static void main(String[] args) {

		ObservableFromArray observableFromArray = new ObservableFromArray();
		observableFromArray.array();
		observableFromArray.arrayIntWorng();
		observableFromArray.arrayInt();
	}

	class User {
		public int idx;
		public String name;
		public String msg;
		
		public User(int idx , String name , String msg)
		{
			this.idx = idx;
			this.name = name;
			this.msg = msg;
		}
	}

}
