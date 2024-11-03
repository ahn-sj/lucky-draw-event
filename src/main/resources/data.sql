INSERT INTO `USERS` (`USER_ID`, `USER_NAME`, `CREATED_AT`, `UPDATED_AT`) VALUES
(1, 'user1', NOW(), NOW()),
(2, 'user2', NOW(), NOW()),
(3, 'user3', NOW(), NOW());

INSERT INTO `PRODUCTS` (`PRODUCT_ID`, `PRODUCT_NAME`, `PRODUCT_STATUS`, `CREATED_AT`, `UPDATED_AT`) VALUES
(1, 'product1', 'ACTIVE', NOW(), NOW()),
(2, 'product2', 'ACTIVE', NOW(), NOW()),
(3, 'product3', 'ACTIVE', NOW(), NOW()),
(4, 'product4', 'ACTIVE', NOW(), NOW()),
(5, 'product5', 'ACTIVE', NOW(), NOW());

INSERT INTO `EVENTS` (`EVENT_ID`, `EVENT_NAME`, `EVENT_TYPE`, `START_DT`, `END_DT`, `RANK_PROBABILITIES`, `EVENT_STATUS`, `CREATED_AT`, `UPDATED_AT`) VALUES
(1, 'event1', 'LUCKY_DRAW', '2024-10-01 00:00:00', '2024-11-10 00:00:00', '{"0":0,"1":5,"2":10,"3":15,"4":20,"5":50}', 'ACTIVE', NOW(), NOW()),
(2, 'event2', 'LUCKY_DRAW', '2024-10-01 00:00:00', '2024-11-10 00:00:00', '{"0":0,"1":5,"2":10,"3":15,"4":20,"5":50}', 'INACTIVE', NOW(), NOW()),
(3, 'event3', 'LUCKY_DRAW', '2024-10-01 00:00:00', '2024-11-10 00:00:00', '{"0":0,"1":5,"2":10,"3":15,"4":20,"5":50}', 'ACTIVE', NOW(), NOW());

INSERT INTO `EVENT_PRODUCTS` (`EVENT_PRODUCT_ID`, `EVENT_PRODUCT_NAME`, `MAX_QUANTITY`,  `PRODUCT_ID`, `EVENT_ID`, `CREATED_AT`, `UPDATED_AT`) VALUES
(1, '(event) product1', 100, 1, 1, NOW(), NOW()),
(2, '(event) product2', 200, 2, 1, NOW(), NOW()),
(3, '(event) product3', 300, 3, 1, NOW(), NOW()),
(4, '(event) product4', 400, 4, 1, NOW(), NOW()),
(5, '(event) product5', 500, 5, 1, NOW(), NOW());

INSERT INTO `EVENT_PRODUCT_STOCKS` (`EVENT_PRODUCT_STOCK_ID`, `EVENT_PRODUCT_ID`, `STOCK_QUANTITY`, `VERSION`, `CREATED_AT`, `UPDATED_AT`) VALUES
(1, 1, 0, 0, NOW(), NOW()),
(2, 2, 0, 0, NOW(), NOW()),
(3, 3, 0, 0, NOW(), NOW()),
(4, 4, 0, 0, NOW(), NOW()),
(5, 5, 0, 0, NOW(), NOW());


