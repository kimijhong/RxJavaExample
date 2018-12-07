package example;
import io.reactivex.Observable;
import io.reactivex.functions.Function;

public class Gogodan {

	public void emit() {
		int dan = 4;

		/*
		 * for (int i = 1; i < 10; i++) { System.out.println(dan + " * " + i +
		 * " = " + (i * 3)); }
		 */

		// Observable<String> observable = Observable.range(1, 9);

		// observable.flatMap(num ->{return ""};)
		// observable.map(data -> { return dan + " * " + data + " = " + (data *
		// 3);}).subscribe(System.out::println);
		// observable.subscribe(System.out::println);

		/*
		 * observable.subscribe(data ->{ System.out.println(dan + " * " + data +
		 * " = " + (data * 3)); });
		 */

		Observable.range(2, 8).flatMap(gugudan).subscribe(System.out::println);
		//Observable.just(dan).flatMap(gugudan).subscribe(System.out::println);

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Gogodan gogodan = new Gogodan();
		gogodan.emit();

	}

	Function<Integer, Observable<String>> gugudan = dan -> 

		 Observable.range(1, 9).map(var -> dan + " * " + var + " = " + (var * dan));

	;

}
