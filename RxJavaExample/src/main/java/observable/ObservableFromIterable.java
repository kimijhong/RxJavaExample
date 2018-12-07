package observable;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

import comm.Order;
import io.reactivex.Observable;

public class ObservableFromIterable {

	public static void main(String[] args) {
		

		/////////////////////////////////////////////////////////////////////////////////////
		List items = new ArrayList<String>();
		items.add("Jarry");
		items.add("Jarry2");
		items.add("Jarry3");

		Observable observablelist = Observable.fromIterable(items);
		observablelist.subscribe(System.out::println);

		Set items2 = new HashSet<>();
		items2.add("item1");
		items2.add("item1");
		items2.add("item2");
		items2.add("item2");
		items2.add("item3");

		observablelist = Observable.fromIterable(items2);
		observablelist.subscribe(System.out::println);

		BlockingQueue<Order> blockingQueue = new ArrayBlockingQueue<>(100);
		blockingQueue.add(new Order("0dd-1"));
		blockingQueue.add(new Order("0dd-2"));
		blockingQueue.add(new Order("0dd-3"));
		blockingQueue.add(new Order("0dd-4"));

		Observable<Order> observable4 = Observable.fromIterable(blockingQueue);
		observable4.subscribe(data -> {

			System.out.println(data.getId());
		});

	}

}
