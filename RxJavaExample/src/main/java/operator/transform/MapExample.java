package operator.transform;

import comm.Log;
import io.reactivex.Observable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.functions.Predicate;

public class MapExample {

	public void mapFunction() {
		String balls[] = { "1", "2", "3", "5" };

		Observable<String> observable = Observable.fromArray(balls)
		.map(data -> {
			return data + "<>";
		});
		observable.doOnComplete(() -> {
			System.out.println("complete !!");
		});
		observable.subscribe(Log::it);
		
		/*--------------Function 클래스를 이용용한 처리---------------------------*/

		Observable.fromArray(balls).map(getDiamond).subscribe(Log::it);
	}

	public void mappingType() {
		String balls[] = { "RED", "GREEN", "BLUE"};
		Observable<Integer> observable = Observable.fromArray(balls).map(ballToIndex);
		observable.subscribe(Log::it);
	}


	Function<String, Integer> ballToIndex = ball -> {
		switch (ball) {
		case "RED":
			return 1;
		case "GREEN":
			return 2;
		case "BLUE":
			return 3;
		default:
			return -1;
		}
	};

	Function<String, String> getDiamond = data -> {
		// 값을 받아처리 결과를 처리한다.
		return data + "<>";
	};

	Consumer<String> consumer = (data) -> {
		// 데이터값을 받아 처리 반환값은 없다!
	};

	Predicate<String> predicate = (data) -> {
		// 값을받아 처리반환값은 boolean
		return true;
	};
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MapExample example = new MapExample();
		example.mapFunction();
		example.mappingType();
	}


}
