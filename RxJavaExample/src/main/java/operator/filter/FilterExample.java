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
		
		
		//첫번째 값을 리턴 없으면 기본값 -1
		single = Observable.fromArray(numbers)
				.first(-1);
		single.subscribe(System.out::println).dispose();
		
		CommUtil.exampleComplete();
	
		
		//마지막값 없으면 기본값 -1
		single = Observable.fromArray(numbers)
				.last(-1);
		single.subscribe(System.out::println);
		
		
		CommUtil.exampleComplete();
		
		//첫번째에서 n개
		observable = Observable.fromArray(numbers)
				.take(3);
		observable.subscribe(System.out::println);
		CommUtil.exampleComplete();
		
		//n부터 마지막까지
		observable = Observable.fromArray(numbers)
				.takeLast(3);
		observable.subscribe(System.out::println);
		CommUtil.exampleComplete();
		
		//n까지 건너띄고 마지막까지
		observable = Observable.fromArray(numbers)
				.skip(3);
		observable.subscribe(System.out::println);
		CommUtil.exampleComplete();
		
		
		//마지막부터 n까지 건너띄고 처금값까지
		observable = Observable.fromArray(numbers)
				.skipLast(2);
		observable.subscribe(System.out::println);
	}

	public static void main(String[] args) {

		new FilterExample().emit();
	}

}
