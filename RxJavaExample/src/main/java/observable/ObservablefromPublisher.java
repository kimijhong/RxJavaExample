package observable;

import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;

import io.reactivex.Observable;

public class ObservablefromPublisher {
	/*
	 * stream 을이용할때 사용?
	 */
	public void basic()
	{
		Publisher<String> publisher = (Subscriber<? super String> s) ->{
			s.onNext("hello onNext publisher");
			s.onNext("hello onNext publisher1");
			s.onComplete();
		};
		
		Observable<String> observable  = Observable.fromPublisher(publisher);
		observable.subscribe(System.out::println);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new ObservablefromPublisher().basic();
	}

}
