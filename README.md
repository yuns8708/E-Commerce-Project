# E-Commerce-Project
로그인, 회원가입과 사용자 유형별 상품 관리 기능을 구현한 이커머스 프로젝트입니다.

## 프로젝트 기능 및 설계

- 회원가입 기능
  - 사용자는 회원가입을 할 수 있다.
  - 고객(CUSTOMER), 상품 등록자(SELLER), 관리자(ADMIN) 권한으로 나뉘고, 일반 사용자들은 고객 또는 상품 등록자로 회원가입 할 수 있다.
  - 아이디, 패스워드, 전화 번호, 사용자 분류 타입, 가입 시간이 필요하며 아이디는 unique해야한다.
  - 패스워드를 DB에 저장 시 암호화한다.
- 로그인, 로그아웃 기능
  - 사용자는 로그인 할 수 있다. 로그인 시 회원가입때 사용한 아이디와 패스워드가 일치해야한다.
  - Spring Security와 Jwt Token을 사용한다.
  - 사용자는 로그아웃 할 수 있다. 로그아웃 시 장바구니에 접근할 수 없다.
- 상품 등록 기능 (SELLER)
  - 상품 등록자는 상품을 등록할 수 있다. 등록 시 상품 아이디, 상품명, 상품 가격, 상품 상세 설명, 상품 이미지, 상품 등록 시간이 필요하며 상품 아이디는 unique해야한다.
  - 상품 이미지는 Amazon S3의 bucket를 사용하여 업로드된 URL을 DB에 저장한다.
- 상품 정보 수정 기능 (SELLER)
  - 상품 등록자는 상품을 수정할 수 있다. 상품명, 상품 가격, 상품 상세 설명, 상품 이미지를 수정할 수 있다.
- 상품 삭제 기능 (SELLER)
  - 상품 등록자는 상품을 삭제할 수 있다.
- 등록한 상품 목록 조회 기능 (SELLER)
  - 상품 등록자는 자신이 등록한 상품 리스트를 조회할 수 있다.
  - 상품이 등록된 시간순(오름차순)으로 정렬한다.
- 상품 검색 기능
  - 고객과 상품 등록자는 상품명으로 상품을 검색할 수 있다.
- 상품 목록 조회 기능
  - 모든 사용자는 상품 리스트를 조회할 수 있다. 상품명, 상품 가격, 상품 이미지를 조회할 수 있다.
  - 기본적으로 상품이 등록된 시간순(오름차순)으로 정렬되며, 이름순, 가격순으로 정렬할 수 있다.
  - 상품 리스트는 한 페이지당 최대 20개의 상품이 보이도록 페이징 처리한다.(JPA Pageable사용)
- 상품 상세 정보 조회 기능
  - 모든 사용자는 상품 상세 정보를 조회할 수 있다. 상품명, 상품 가격, 상품 상세 설명, 상품 이미지를 조회할 수 있다.
- 상품 장바구니 담기 기능 (CUSTOMER)
  - 고객은 상품을 장바구니에 담을 수 있다. 장바구니 아이디, 장바구니 상품 총 개수, 장바구니 상품 총 가격, 장바구니 등록 회원 정보, 장바구니 등록 상품 정보가 필요하며 장바구니 아이디는 unique해야한다.
- 상품 장바구니 조회 기능 (CUSTOMER)
  - 고객은 장바구니 리스트를 조회할 수 있다. 상품명, 상품 가격, 상품 이미지를 조회할 수 있다.
  - 장바구니 목록은 장바구니를 담은 시간순(오름차순)으로 정렬한다.
- 상품 장바구니 삭제 기능 (CUSTOMER)
  - 고객은 장바구니의 상품을 삭제할 수 있다.
- 관리자 권한 제한
    - 관리자는 상품을 삭제할 수 있지만, 등록, 수정할 수 없다.
    - 관리자는 장바구니 담기, 조회, 삭제를 할 수 없다.
- 고객 권한 제한
  - 고객은 상품을 등록, 수정, 삭제할 수 없다. 
- 상품 등록자 권한 제한
  - 상품 등록자는 장바구니 담기, 조회, 삭제를 할 수 없다.


## ERD

<img width="1112" alt="Image" src="https://github.com/user-attachments/assets/66ce8720-a951-4e6a-9c88-047e59ff686a" />


## Trouble Shooting


## Tech Stack
<img src="https://img.shields.io/badge/spring-6DB33F?style=for-the-badge&logo=spring&logoColor=white">

<img src="https://img.shields.io/badge/springboot-6DB33F?style=for-the-badge&logo=springboot&logoColor=white">

<img src="https://img.shields.io/badge/springsecurity-6DB33F?style=for-the-badge&logo=springsecurity&logoColor=white">

<img src="https://img.shields.io/badge/gradle-02303A?style=for-the-badge&logo=gradle&logoColor=white">

<img src="https://img.shields.io/badge/mysql-4479A1?style=for-the-badge&logo=mysql&logoColor=white">

<img src="https://img.shields.io/badge/amazons3-569A31?style=for-the-badge&logo=amazons3&logoColor=white">

