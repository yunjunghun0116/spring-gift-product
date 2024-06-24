# [STEP-2] 상품 선물하기

### 프로그래밍 요구 사항 
- 자바 코드 컨벤션을 지키면서 프로그래밍 한다. (들여쓰기는 '4 spaces' 로 한다)
- indent (들여쓰기) depth 를 3이 넘지 않도록 구현한다.
- 3항 연산자를 사용하지 않는다.
- 함수는 한가지 일만 하도록 최대한 작게 만든다.
- 함수의 길이가 15 라인을 넘어가지 않도록 구현한다.
- JUnit 5 와 AssertJ 를 이용하여 정리한 기능 목록이 정상적으로 작동하는지 테스트 코드로 확인한다.
- else 예약어를 사용하지 않는다.
- 도메인 로직에 단위 테스트를 구현해야 한다.(핵심 로직을 구현하는 코드와 UI를 담당하는 로직을 분리해 구현한다.)

### 기능 요구 사항
![이미지1](../../../../../../var/folders/jy/nryfqst9543gz77whctsvy0c0000gn/T/TemporaryItems/NSIRD_screencaptureui_KPitu5/스크린샷 2024-06-24 오후 7.41.52.png)
- [ ] 상품을 조회, 추가, 수정, 삭제할 수 있는 간단한 HTTP API를 구현한다.
- [ ] HTTP 요청과 응답은 JSON 형식으로 주고받는다.
- [ ] 현재는 별도의 데이터베이스가 없으므로 적절한 자바 컬렉션 프레임워크를 사용하여 메모리에 저장한다.

### 힌트
- 상품 데이터 관리 : 현재는 별도의 데이터베이스가 없으므로 적절한 컬렉션을 이용하여 메모리에 저장한다.