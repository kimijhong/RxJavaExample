import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.stream.IntStream;

import comm.Order;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;

public class FirstExample {

	Action completeAction = () -> {
		System.out.println("--------------이벤트 완료-------------");
	};

	public void emit() {
		
		/**
		 * 상황에 맞게 Observalble ,Single ,Maybe ,Flowable 클래스로 구분해 사용한다.
		 */

		// 리엑티브 프로그래밍은 Observable로 시작한다.
		Observable.just("hello", "Rxjava2", 1234).subscribe(System.out::println); // 메서드

		/** just **/

		// just로 넣은 데이터는 그대로 발행 최대 10개까지

		Observable.just(1, 2, 3, 4, 5, "@@@@\n").doOnNext(data -> {
			System.out.println(data);
		}).doOnError(err -> {
			System.out.println(err.getMessage());
		}).doOnComplete(() -> {
			System.out.println("-------------- Observable 이벤트 완료-------------");
		}).subscribe(data -> {
			System.out.print(data);
		}, err -> {
			System.out.print(err.getMessage());
		}, () -> {
			System.out.println("-------------- subscribe 이벤트 완료-------------");
		});
	}

	public static void main(String args[]) {
		FirstExample first = new FirstExample();
		first.emit();
	}

}
