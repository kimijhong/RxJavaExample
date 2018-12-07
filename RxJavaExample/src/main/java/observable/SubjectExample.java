package observable;
import java.util.concurrent.TimeUnit;

import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.observables.ConnectableObservable;
import io.reactivex.subjects.AsyncSubject;
import io.reactivex.subjects.BehaviorSubject;
import io.reactivex.subjects.PublishSubject;
import io.reactivex.subjects.ReplaySubject;

public class SubjectExample {
	
	/**
	 * 차가운 Observable을 뜨거운 Observable로 바꿔준다
	 * 데이터를 발행할수도 있고 구독자처럼 발행된 데이터를 바로 처리할수도 있다.
	 * Observable의 속성과 구독자의 속성을 모두 가지고 있다.
	 */
	
	public void asyncSubject()
	{
		/**onComplete 전에 마지막 값만 사용한다. **/
		AsyncSubject<String> asyncSubject = AsyncSubject.create();
		asyncSubject.onNext("6");
		asyncSubject.onNext("4");
		asyncSubject.subscribe(data -> {
			System.out.println("subscriber #1 =>" + data);
		});
		asyncSubject.onNext("1");
		asyncSubject.onNext("2");
		asyncSubject.subscribe(data -> {
			System.out.println("subscriber #2 =>" + data);
		});
		asyncSubject.onNext("5");
		
		asyncSubject.onComplete(); 
		
		asyncSubject.onNext("7"); //onComplete() 이후에 발행한 데이터는 모두 무시
		System.out.println("-------------완료--------------");
	}
	
	public void asyncSubjectSubscribe()
	{
		/**
		 * 구독자로 동작하는 AsyncSubject
		 */
		Float[] temperature = { 1.0f, 2.0f, 3.0f };
		Observable<Float> observable = Observable.fromArray(temperature);
		
		AsyncSubject<Float> subject = AsyncSubject.create();
		subject.subscribe(data -> {System.out.println(data);});

		observable.subscribe(subject);
		
	}
	
	public void behaviorSubject ()
	{
		 /** 
		  * 구독자가 구독을하면 가장최근값 혹은 기본값을 넘겨줌 
		  * 데이터가 없으면 기본값 , 있으면 순차적으로 가장최근값 구독자에게 모두 발행 **/
		BehaviorSubject<String> behaviorSubject = BehaviorSubject.createDefault("defalt : 6");
		behaviorSubject.subscribe(data -> {
			System.out.println("BehaviorSubject #1 => " + data); //값이 없으므로 기본값 출력
		});
		behaviorSubject.onNext("1"); //데이터 발행시마다 최근값 출력
		behaviorSubject.onNext("2");
		behaviorSubject.onNext("3");
		
		behaviorSubject.subscribe(data -> {
			System.out.println("BehaviorSubject #2 => " + data);
		}); //가장 최근값 3출력
		
		behaviorSubject.onNext("5"); // 값이 발행이 되면 구독자들은 구독을 한다.
		behaviorSubject.subscribe(data -> {
			System.out.println("BehaviorSubject #3 => " + data);
		});
		behaviorSubject.onComplete();
	}
	
	public void publishSubject()
	{
		/** subscribe()후출이후에 발행되는 값을 출력 들어**/
		PublishSubject<String> publishSubject = PublishSubject.create();
		
		publishSubject.subscribe(data -> {
			System.out.println("publishSubject #1 =>" + data);
		});
		
	
		publishSubject.onNext("1");
		publishSubject.onNext("3");
		publishSubject.subscribe(data -> {
			System.out.println("publishSubject #2 =>" + data);
		});
		publishSubject.onNext("5");

		publishSubject.onComplete();
	}
	
	public void replaySubject()
	{
		/*중간에 들어오는 값은 다 발행*/
		ReplaySubject<String> replaySubject = ReplaySubject.create();
		replaySubject.subscribe(data -> {
			System.out.println("replaySubject #1 =>" + data);
		});
		replaySubject.onNext("1");
		replaySubject.onNext("3");
		replaySubject.subscribe(data -> {
			System.out.println("replaySubject #2 =>" + data);
		});
		replaySubject.onNext("5");

		replaySubject.onComplete();
		
	}
	
	public void emit() {

		/////////////////////////////////////////////////////////////////
	
	

	}
	
	Observer<String> observer = new Observer<String>() {
		
		@Override
		public void onSubscribe(Disposable d) {
			// TODO Auto-generated method stub
			
		}
		
		@Override
		public void onNext(String t) {
			// TODO Auto-generated method stub
			
		}
		
		@Override
		public void onError(Throwable e) {
			// TODO Auto-generated method stub
			
		}
		
		@Override
		public void onComplete() {
			// TODO Auto-generated method stub
			
		}
	};
	
	Subscriber<String> subscriber = new Subscriber<String>() {
		
		@Override
		public void onSubscribe(Subscription s) {
			// TODO Auto-generated method stub
			
		}
		
		@Override
		public void onNext(String t) {
			// TODO Auto-generated method stub
			
		}
		
		@Override
		public void onError(Throwable t) {
			// TODO Auto-generated method stub
			
		}
		
		@Override
		public void onComplete() {
			// TODO Auto-generated method stub
			
		}
	};
	
	Consumer<String> consumer = new Consumer<String>() {
		
		@Override
		public void accept(String t) throws Exception {
			// TODO Auto-generated method stub
			
		}
	};

	public static void main(String[] args) {

		SubjectExample example = new SubjectExample();
		example.asyncSubject();
		example.asyncSubjectSubscribe();
		example.behaviorSubject();
		example.publishSubject();
		example.replaySubject();
	}
}
