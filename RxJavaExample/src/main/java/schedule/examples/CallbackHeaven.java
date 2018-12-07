package schedule.examples;

import comm.CommUtil;
import comm.Log;
import comm.OkHttpHelper;
import io.reactivex.Maybe;
import io.reactivex.Observable;
import io.reactivex.schedulers.Schedulers;

public class CallbackHeaven {
	private static final String FIRST_URL = "https://api.github.com/zen";
	private static final String SECOND_URL = CommUtil.GITHUB_ROOT + "/samples/callback_heaven";
	
	public void usingConcat() { 
		CommUtil.exampleStart();
		Observable<String> source = Observable.just(FIRST_URL)
			.subscribeOn(Schedulers.io())
			.map(OkHttpHelper::get)
			.concatWith(Observable.just(SECOND_URL)
		    .map(OkHttpHelper::get));
		source.subscribe(Log::it);

		CommUtil.sleep(5000);
		CommUtil.exampleComplete();
	}

	public void usingZip() { 
		CommUtil.exampleStart();
		Observable<String> first = Observable.just(FIRST_URL)
				.subscribeOn(Schedulers.io())
				.map(OkHttpHelper::get);
		Observable<String> second = Observable.just(SECOND_URL)
				.subscribeOn(Schedulers.io())
				.map(OkHttpHelper::get);
		
		Observable.zip(first, second, 
				(a, b) -> ("\n>>" + a + "\n>>" + b))
			.subscribe(Log::it);
		CommUtil.sleep(5000);
	}
	
	public static void main(String[] args) { 
		CallbackHeaven demo = new CallbackHeaven();
		demo.usingConcat();
		demo.usingZip();
	}
}
