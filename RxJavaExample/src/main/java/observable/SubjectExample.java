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
	 * ������ Observable�� �߰ſ� Observable�� �ٲ��ش�
	 * �����͸� �����Ҽ��� �ְ� ������ó�� ����� �����͸� �ٷ� ó���Ҽ��� �ִ�.
	 * Observable�� �Ӽ��� �������� �Ӽ��� ��� ������ �ִ�.
	 */
	
	public void asyncSubject()
	{
		/**onComplete ���� ������ ���� ����Ѵ�. **/
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
		
		asyncSubject.onNext("7"); //onComplete() ���Ŀ� ������ �����ʹ� ��� ����
		System.out.println("-------------�Ϸ�--------------");
	}
	
	public void asyncSubjectSubscribe()
	{
		/**
		 * �����ڷ� �����ϴ� AsyncSubject
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
		  * �����ڰ� �������ϸ� �����ֱٰ� Ȥ�� �⺻���� �Ѱ��� 
		  * �����Ͱ� ������ �⺻�� , ������ ���������� �����ֱٰ� �����ڿ��� ��� ���� **/
		BehaviorSubject<String> behaviorSubject = BehaviorSubject.createDefault("defalt : 6");
		behaviorSubject.subscribe(data -> {
			System.out.println("BehaviorSubject #1 => " + data); //���� �����Ƿ� �⺻�� ���
		});
		behaviorSubject.onNext("1"); //������ ����ø��� �ֱٰ� ���
		behaviorSubject.onNext("2");
		behaviorSubject.onNext("3");
		
		behaviorSubject.subscribe(data -> {
			System.out.println("BehaviorSubject #2 => " + data);
		}); //���� �ֱٰ� 3���
		
		behaviorSubject.onNext("5"); // ���� ������ �Ǹ� �����ڵ��� ������ �Ѵ�.
		behaviorSubject.subscribe(data -> {
			System.out.println("BehaviorSubject #3 => " + data);
		});
		behaviorSubject.onComplete();
	}
	
	public void publishSubject()
	{
		/** subscribe()�������Ŀ� ����Ǵ� ���� ��� ���**/
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
		/*�߰��� ������ ���� �� ����*/
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
