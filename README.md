![Header](https://capsule-render.vercel.app/api?type=waving&customColorList=8,78,127,39,195,247&color=gradient&text=TemFriend&fontColor=ffffff&animation=fadeIn)

우리는 우리의 템포로 친해진다!<br/>
등급제도로 운영되는 친구 커뮤니티<br/>

<br/>

### 📚 기술 스택

<img src="https://img.shields.io/badge/Java  17-007396?style=flat-square&logo=openJDK&logoColor=white&style=flat"/></a>
<img src="https://img.shields.io/badge/Spring Boot 2.7.14-6DB33F?style=flat-square&logo=Springboot&logoColor=white&style=flat"/></a>
<img src="https://img.shields.io/badge/Spring Security-6DB33F?style=flat-&logo=springsecurity&logoColor=white&style=flat"/></a>
<img src="https://img.shields.io/badge/Spring Data JPA-gray?style=flat-square&logo=DataJPA&logoColor=white&style=flat"/></a>
<br/>
<img src="https://img.shields.io/badge/Junit-25A162?style=flat-&logo=JUnit5&logoColor=white&style=flat"/></a>
<img src="https://img.shields.io/badge/JWT-black?logo=jsonwebtokens&logoColor=pink&style=flat-square"/></a>
<img src="https://img.shields.io/badge/MapStruct-gray?logo=MapStruct&logoColor=#147284&style=flat-square"/></a>
<br/>
<img src="https://img.shields.io/badge/MySQL-4479A1?style=flat-square&logo=MySQL&logoColor=white&style=flat"/></a>
<img src="https://img.shields.io/badge/Redis-beige?logo=redis&logoColor=#DC382D&style=flat-square"/></a>
<img src="https://img.shields.io/badge/H2-4479A1?style=flat-square&logo=H2&logoColor=white&style=flat"/></a>
<img src="https://img.shields.io/badge/Flyway-CC0200?logo=flyway&logoColor=fff&style=flat-square"/></a>
<br/>
<img src="https://img.shields.io/badge/Swagger-85EA2D?style=flat-square&logo=Swagger&logoColor=white&style=flat"/></a>
<img src="https://img.shields.io/badge/Gradle-4429A1?style=flat-square&logo=gradle&logoColor=white&style=flat"/></a>
<img src="https://img.shields.io/badge/DBeaver-gray?logo=dbeaver&logoColor=#382923&style=flat-square"/></a>
<img src="https://img.shields.io/badge/Postman-gray?logo=Postman&logoColor=#FF6C37&style=flat-square"/></a>
<img src="https://img.shields.io/badge/github-gray?logo=github&logoColor=#181717&style=flat-square"/></a>
<br/>


[//]: # (### 🏛️ Architecture)

[//]: # (Swagger : /swagger-ui/index.html<br/>)

[//]: # (git -> gtiHubActions -> AWS -> SpringBootPrj -> RDS -> MySQL)

<br/>

### 🚀 기능 정의서

해당 프로젝트의 기능, 시나리오 등을 정의합니다.
<br/>
<br/>

#### 🎯 회원 가입

사용자는 신규 `회원 가입`이 가능하다.

> - [x] 중복된 이메일은 `가입`에 실패한다.
> - [x] 중복된 닉네임은 `가입`에 실패한다.

#### 🎯 로그인 & 로그아웃

가입한 사용자는 서비스 이용을 위해 `로그인`을 해야 한다.<br/>

> - [x] 이메일과 패스워드로 `로그인` 할 수 있다.
> - [x] 로그인 성공 시 `토큰(JWT)`을 발급한다.
> - [x] 로그아웃은 해당 `토큰(JWT)`을 `Redis` 블랙리스트에 추가하며 만료 시킨다.

#### 🎯 게시글 작성,수정,삭제

로그인한 사용자는 `게시글` 서비스를 이용할 수 있다.<br/>

> - [x] 유효한 `토큰(JWT)`을 가진 요청만 게시글 작성을 할 수 있다.
> - [x] 유효한 `토큰(JWT)`을 가진 요청만 게시글 수정을 할 수 있다.
> - [x] 유효한 `토큰(JWT)`을 가진 요청만 게시글 삭제를 할 수 있다.
> - [x] 게시글 삭제는 컬럼을 `marking` 해 관리하며 실제로 삭제하지 않는다.

#### 🎯 댓글 작성

로그인한 사용자는 게시글에 `댓글`을 작성할 수 있다.<br/>

> - [x] 유효한 `토큰(JWT)`을 가진 요청만 댓글 작성을 할 수 있다.
> - [x] 유효한 `토큰(JWT)`을 가진 요청만 댓글 수정을 할 수 있다.
> - [x] 유효한 `토큰(JWT)`을 가진 요청만 댓글 삭제를 할 수 있다.

#### 🎯 점수 정책

유저의 등급제도에 필요한 점수 정책이다.<br/>
필요 이상의 점수를 획득하면 자동으로 등급이 상승한다.<br/>

> - [x] 로그인 시 `점수`를 획득한다.
> - [x] 게시글 작성 시 `점수`를 획득한다.
> - [ ] 댓글 작성 시 `점수`를 획득한다.
> - [ ] 등급은 `Bronze`, `Silver`, `Gold`, `Platinum`, `Diamond` 이 존재한다.

#### 🎯 활동 내역

유저의 로그인 및 게시글 작성, 댓글 작성 등의 활동 내역을 관리한다.<br/>

> - [x] 로그인 시 획득할 수 있는 점수의 시간은 최소 6시간이다.
> - [x] 게시글 작성 시 획득할 수 있는 점수의 시간은 최소 3시간이다.
> - [ ] 댓글 작성 시 획득할 수 있는 점수의 시간은 최소 x시간이다.

<br/>

### 🚀 커밋 컨벤션

<u>"태그 [클래스명] : 내용"</u> 의 형태로 커밋한다.<br/>
<br/>

| 태그 이름    | 설명                           |
|----------|------------------------------|
| Feat     | 새로운 기능을 추가한 경우               |
| Add      | 기존 기능에 새로운 기능을 추가한 경우        |
| Refactor | 기존 로직과 상관없이 코드를 개선 및 수정한 경우  |
| Rename   | 파일 혹은 폴더명을 수정하거나 옮기는 작업만한 경우 |
| Test     | 테스트와 관련된 경우                  |
| Docs     | 문서와 관련된 경우                   |
| Chore    | 빌드 및 설정과 관련된 경우              |

<br/>
<br/>

---

© 2023 TemFriend. All rights reserved.<br/>
Designed with ❤️ by [lkdcode]