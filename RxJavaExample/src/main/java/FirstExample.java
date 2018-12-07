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
		System.out.println("--------------�̺�Ʈ �Ϸ�-------------");
	};

	public void emit() {
		
		/**
		 * ��Ȳ�� �°� Observalble ,Single ,Maybe ,Flowable Ŭ������ ������ ����Ѵ�.
		 */

		// ����Ƽ�� ���α׷����� Observable�� �����Ѵ�.
		Observable.just("hello", "Rxjava2", 1234).subscribe(System.out::println); // �޼���

		/** just **/

		// just�� ���� �����ʹ� �״�� ���� �ִ� 10������

		Observable.just(1, 2, 3, 4, 5, "@@@@\n").doOnNext(data -> {
			System.out.println(data);
		}).doOnError(err -> {
			System.out.println(err.getMessage());
		}).doOnComplete(() -> {
			System.out.println("-------------- Observable �̺�Ʈ �Ϸ�-------------");
		}).subscribe(data -> {
			System.out.print(data);
		}, err -> {
			System.out.print(err.getMessage());
		}, () -> {
			System.out.println("-------------- subscribe �̺�Ʈ �Ϸ�-------------");
		});
	}

	public static void main(String args[]) {
		FirstExample first = new FirstExample();
		first.emit();
	}

}
