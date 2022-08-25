# ibini books 소개
- 이비니 북스는 5명의 학생이 웹 프로그램 개발 공부 목적으로 만들고 있는 사이트입니다.
- 이비니 프로젝트는 여러 곳에서 여러 형태로 구독, 감상하고 있는 콘텐츠를 한 곳에 기록해서 효율적으로 관리해보고자 만들어진 비영리 학습용 웹 사이트입니다.
- 1차 목표로는 원하는 도서의 정보와 사용자가 읽고 있는 정보를 기록하고 조회하는 것으로 도서 검색 api를 적용해보고자 합니다.
- 깔쌈하게 멋진 프로그램 만들어보겠습니다 많관부!


--------------------------------------------------------------------------------------------------

# application.properties 설정
## 톰캣 포트
- server.port = 8383
## view resolver setting
- spring.mvc.view.prefix=/WEB-INF/views/
- spring.mvc.view.suffix=.jsp

------------------------------------------------------------

# 깃헙 작업 방법
## 푸시, 패치, 병합을 할 때는 모든 변경사항들이 커밋된 상태여야 합니다
- 만약 마스터에서 작업을 했다면 변경사항 롤백해 주시고 각자 브랜치에 다시 작업해 주세요
## 커밋 메시지는 통일해주세요
- 예시) [22.08.09 여운] 패키지 초기화

1. (개인) 개별 작업물 브랜치에 푸시하기
2. (개인) 팀장한테 브랜치에 푸시했으니 병합해달라고 하기
3. (팀장) 개별 작업물이 담긴 브랜치를 merge_master에 병합
4. (팀장) 버그가 없다면 master에 적용 후 푸시
5. (개인) 병합 완료되면 인텔리제이 git > 페치 클릭
6. (개인) 페치 끝나면 각자 브랜치에서 마스터를 병합
- 인텔리제이 git > 병합 > 마스터 선택

------------------------------------------------------------

# 수정 사항
## 작업 중 다른 분들이 알아야 할 수정 사항이 생긴다면 여기에 써주세요

- (08.09 - 여운) public_status 값 변경 > (고정)0:미분류 1:연재중 , 2: 휴재, 3: 완결
- (08.09 - 여운) tbl_post 제약조건 변경
- (08.09 - 성빈) prj_post_img 테이블, reg_date DATE DEFAULT SYSDATE 컬럼 추가
- (08.09 - 현정) prj_category 테이블 삭제, CategoryUtil에서 값 불러오게 변경
- (08.09 - 재영) member 테이블 컬럼(session_id, limit_time
  ) 추가, create table tbl_member sql문 수정
- (08.08 - 여운) 프로젝트 파일 깃에 올림


----

header 사용시 include file을 header-wrap으로 감싸주기


            <div id="header-wrap">
                <%@ include file="./include/header.jsp" %>
            </div>

content 구역은 content-wrap으로 감싸서 header랑 content-wrap 분리후 사용

      <div id="content-wrap">
          <h1> Welcome~ This is ibini's index page!! </h1>
  
          <a href="/list">포스트 전체 목록</a> <br>
          <a href="/post/write/${account}">새 포스트 쓰기</a> <br>
      </div>