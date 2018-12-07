package observable;

import comm.Order;
import io.reactivex.Observable;
import io.reactivex.Single;

public class SingleExample {

	/**
	 * 오직 1개의 데이터만 발행하도록 한정
	 */
	public static void main(String[] args) {
		
		Single<String> single = Single.just("Hello Single");
		single.subscribe(System.out::println);
		
		//기존 Observable에서 Single 객체 변환 just에 여러개가 들어가면 에러
		Observable<String> source = Observable.just("Observable to single");
		Single.fromObservable(source)
		.doOnError(err->{System.out.println(err.getMessage());})
		.subscribe(data->{System.out.println(data);});
		
		//싱글함수를 이용해 single 객체 생성
		Observable.just("single() 함수이용").single("default item").subscribe(System.out::println);
		
		//first()함수를 호출해 single 객체 생성
		String colors[] = {"red","blue","black"};
		Observable.fromArray(colors)
		.first("default value")
		.subscribe(System.out::println);
		
		//empty 에서 single 객체 생성
		Observable.empty()
		.single("default value")
		.subscribe(System.out::println);
		
		//take() 함수에서 single 객체 생성
		Observable.just(new Order("item-1"),new Order("item-2"))
		.take(1)
		.single(new Order("default order"))
		.subscribe(data->{
			System.out.println(data.getId());
		});
		
		
		//싱글클래스 데이터를 하나만 발행할수 있도록 한다. 여러개를 발행할경우 에라 에러발생시기는 데이터를 사용시
		Observable.just("Hello Single","error")
		.single("default item")
		.subscribe(System.out::println,
				err->{
					System.out.println("에러메세지 : " + err.getMessage());
					System.out.println("에러처리");
		});
		

	}

}
