1시간 40분동안 만든 앱.

사용한 라이브러리

1. 데이터 바인딩
2. 뷰모델
3. 라이브데이터 
(MovieViewModel.kt 에서 _title 의 값이 바뀔 때마다 영화를 검색하여 movie 의 값을 대입해주었음. 
MainActivity.kt 에서 MovieViewModel.movie 의 값이 바뀔때마다 리사이클러뷰의 notifyDataSetChanged 를 해주었다.)

배운 점

1. conversions 를 이용하여 데이터바인딩을 할 수 있다는 사실을 새롭게 알았다.
2. retrofit 통신을 비동기로 하는 방법을 알게 되었다.
3. retrofit 을 싱글톤 객체로 어떻게 사용해야 하는지 알게 되었다.
4. mvvm 패턴의 전반적인 개념을 알 수 있었다.

