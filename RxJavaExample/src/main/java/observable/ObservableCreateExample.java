package observable;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.functions.Predicate;

public class ObservableCreateExample {

	public static void main(String[] args) {

		////////////////////////////////////////////////////////////////////
		// create()는 onNext ,onComplete, onError를 개발자가 직접 호출해야한다.
		// 개발자가 직접 데이터를 발행
		Observable<Integer> observable = Observable.create((ObservableEmitter<Integer> emitter) -> {
			emitter.onNext(100);
			emitter.onNext(200);
			emitter.onNext(300);
			emitter.onComplete();
		});
		observable.subscribe(System.out::println); // 래퍼런스나 람다식

		/*
		 * Observable.create(new ObservableOnSubscribe<T>() {
		 * 
		 * @Override public void subscribe(ObservableEmitter<T> e) throws
		 * Exception { // TODO Auto-generated method stub
		 * 
		 * } })
		 * 
		 * observable.subscribe(new Consumer<Integer>() {
		 * 
		 * @Override public void accept(Integer data) throws Exception { // TODO
		 * Auto-generated method stub System.out.println(data); } });
		 */

	}

	Consumer consumer = new Consumer<String>() {

		@Override
		public void accept(String input) throws Exception {
			// TODO Auto-generated method stub

		}
	};
	
	Predicate<String> predicate = new Predicate<String>() {
		
		@Override
		public boolean test(String t) throws Exception {
			// TODO Auto-generated method stub
			return false;
		}
	};
	
	Function<String, Integer> function = new Function<String, Integer>() {
		
		@Override
		public Integer apply(String input) throws Exception {
			// TODO Auto-generated method stub
			return null;
		}
	};

}
