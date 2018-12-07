package operator.transform;

import io.reactivex.Observable;
import io.reactivex.functions.Function;

public class FlatMapExample {
	
	/*
	 * 결과가 Observable로 나온다는게 map()과의 차이
	 */

	public void marblediagram() {

		String balls[] = {"1","2","3"};
		
		Observable<String> observable  = Observable.fromArray(balls).flatMap(getDoublediamonds);
		observable.subscribe(System.out::println);
	}
	
	Function<String, Observable<String>> getDoublediamonds = ball -> {
		return Observable.just(ball + "<>",ball + "%");
	};

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FlatMapExample example = new FlatMapExample();
		example.marblediagram();
		// example.mappingType();
	}

}
