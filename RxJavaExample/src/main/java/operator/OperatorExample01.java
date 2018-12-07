package operator;
import org.apache.commons.math3.analysis.function.Log;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Function;
import io.reactivex.functions.Predicate;

public class OperatorExample01 {

	/* */
	public void emit() {
		String balls[] = { "red", "blue", "black"};
		

		/*
		 * Observable<String> observable = Observable.fromArray(balls).map(new
		 * Function<String, String>() {
		 * 
		 * @Override public String apply(String t) throws Exception {
		 * 
		 * return getBalls(t); } });
		 */


		// Observable<String> observable = Observable.fromArray(balls).map(data
		// -> data + "&" );
		
		// Observable<String> observable = Observable.fromArray(balls).map(data -> getBalls(data) );
		//Observable<Integer> observable = Observable.fromArray(balls).map(getBalltoIndex);
		//observable.subscribe(data -> {
		//	System.out.println(data);
		//});
		
		
		///////////////////////////////////////////////////////////////////////////////////////
		//Observable<String> soObservable = Observable.fromArray(balls);
		//soObservable.flatMap(ball-> Observable.just(ball + "&&",ball + "&&",ball + "&&",ball + "&&")).subscribe(System.out::println);
		//soObservable
		
		String objs[] = {"a","b","c"};
		
		Observable<String> observable2 = Observable.fromArray(objs);
		observable2.filter(obj -> {
			
			//obj.equals("");
			
			return obj.equals("¤·");
			
		})
		.isEmpty()
		.subscribe(this::action);
		

	}
	
	public void action(boolean action)
	{
		if(action)
		{
			System.out.println("¾ø´Ù");
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		OperatorExample01 example01 = new OperatorExample01();
		example01.emit();
	}

	Function<String, Integer> getBalltoIndex = data -> {
		int index = 0;
		switch (data) {
		case "red":
			index = 1;
			break;
		case "blue":
			index = 2;
			break;
		case "black":
			index = 3;
			break;
		default:
			index = 0;
		}

		return index;
	};

	public String getBalls(String data) {

		return data + "&";
	}
	
	Function<String, Observable<String>> getDoubleDiaMonds = ball -> {
		System.out.println("AAA");
		return Observable.just(ball + "%" , ball + "%");
	};

}
