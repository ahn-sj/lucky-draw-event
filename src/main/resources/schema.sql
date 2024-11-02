DROP TABLE IF EXISTS users;
CREATE TABLE users (
    user_id    BIGINT       NOT NULL AUTO_INCREMENT COMMENT '사용자 ID',
    user_name  VARCHAR(64)  NOT NULL COMMENT '사용자 이름',
    created_at DATETIME     NOT NULL COMMENT '생성일시',
    updated_at DATETIME     NOT NULL COMMENT '수정일시',
    PRIMARY KEY (user_id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT = '사용자';

DROP TABLE IF EXISTS products;
CREATE TABLE products (
    product_id     BIGINT       NOT NULL AUTO_INCREMENT COMMENT '상품 ID',
    product_name   VARCHAR(100) NOT NULL COMMENT '상품 이름',
    product_status VARCHAR(64)  NOT NULL COMMENT '상품 상태',
    created_at     DATETIME     NOT NULL COMMENT '생성일시',
    updated_at     DATETIME     NOT NULL COMMENT '수정일시',
    PRIMARY KEY (product_id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT = '상품';

DROP TABLE IF EXISTS events;
CREATE TABLE events (
    event_id     BIGINT       NOT NULL AUTO_INCREMENT COMMENT '이벤트 ID',
    event_name   VARCHAR(100) NOT NULL COMMENT '이벤트 이름',
    event_type   VARCHAR(64)  NOT NULL COMMENT '이벤트 유형',
    start_dt     DATETIME     NOT NULL COMMENT '이벤트 시작일시',
    end_dt       DATETIME     NOT NULL COMMENT '이벤트 종료일시',
    event_status VARCHAR(64)  NOT NULL COMMENT '이벤트 상태',
    created_at   DATETIME     NOT NULL COMMENT '생성일시',
    updated_at   DATETIME     NOT NULL COMMENT '수정일시',
    PRIMARY KEY (event_id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT = '이벤트';

DROP TABLE IF EXISTS event_product_stocks;
CREATE TABLE event_product_stocks (
    event_product_stock_id BIGINT   NOT NULL AUTO_INCREMENT COMMENT '이벤트 상품 재고 ID',
    event_product_id       BIGINT   NOT NULL COMMENT '이벤트 상품 ID',
    stock_quantity         INTEGER  NOT NULL COMMENT '현재 재고 수량',
    version                BIGINT   NOT NULL DEFAULT 0 COMMENT '버전',
    created_at             DATETIME NOT NULL COMMENT '생성일시',
    updated_at             DATETIME NOT NULL COMMENT '수정일시',
    PRIMARY KEY (event_product_stock_id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='이벤트 상품 재고';

DROP TABLE IF EXISTS event_products;
CREATE TABLE event_products (
    event_product_id   BIGINT       NOT NULL AUTO_INCREMENT COMMENT '이벤트 상품 ID',
    event_product_name VARCHAR(100) NOT NULL COMMENT '이벤트 상품 이름',
    max_quantity       INTEGER      NOT NULL COMMENT '최대 판매 가능 수량',
    rank_probabilities JSON         NOT NULL COMMENT '등수 비율',
    product_id         BIGINT       NOT NULL COMMENT '상품 ID',
    event_id           BIGINT       NOT NULL COMMENT '이벤트 ID',
    created_at         DATETIME     NOT NULL COMMENT '생성일시',
    updated_at         DATETIME     NOT NULL COMMENT '수정일시',
    PRIMARY KEY (event_product_id)
) ENGINE = InnoDB DEFAULT CHARSET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '이벤트 상품';