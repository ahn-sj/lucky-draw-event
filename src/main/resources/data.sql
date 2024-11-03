INSERT INTO `users` (`user_id`, `user_name`, `created_at`, `updated_at`)
VALUES (1, 'user1', NOW(), NOW()),
       (2, 'user2', NOW(), NOW()),
       (3, 'user3', NOW(), NOW());

INSERT INTO `products` (`product_id`, `product_name`, `product_status`, `created_at`, `updated_at`)
VALUES (1, 'product1', 'ACTIVE', NOW(), NOW()),
       (2, 'product2', 'ACTIVE', NOW(), NOW()),
       (3, 'product3', 'ACTIVE', NOW(), NOW()),
       (4, 'product4', 'ACTIVE', NOW(), NOW()),
       (5, 'product5', 'ACTIVE', NOW(), NOW());

INSERT INTO `events` (`event_id`, `event_name`, `event_type`, `start_dt`, `end_dt`, `rank_probabilities`, `event_status`, `created_at`, `updated_at`)
VALUES (1, 'event1', 'LUCKY_DRAW', '2024-10-01 00:00:00', '2024-11-10 00:00:00', '[{"rank": 0, "probability": 0}, {"rank": 1, "probability": 5}, {"rank": 2, "probability": 10}, {"rank": 3, "probability": 15}, {"rank": 4, "probability": 20}, {"rank": 5, "probability": 50}]', 'IN_PROGRESS', NOW(), NOW());

INSERT INTO `event_products` (`event_product_id`, `event_product_name`, `max_quantity`, `product_id`, `event_id`, `created_at`, `updated_at`)
VALUES (1, '(event) product1', 100, 1, 1, NOW(), NOW()),
       (2, '(event) product2', 200, 2, 1, NOW(), NOW()),
       (3, '(event) product3', 300, 3, 1, NOW(), NOW()),
       (4, '(event) product4', 400, 4, 1, NOW(), NOW()),
       (5, '(event) product5', 500, 5, 1, NOW(), NOW());

INSERT INTO `event_product_stocks` (`event_product_stock_id`, `event_product_id`, `stock_quantity`, `version`, `created_at`, `updated_at`)
VALUES (1, 1, 0, 0, NOW(), NOW()),
       (2, 2, 0, 0, NOW(), NOW()),
       (3, 3, 0, 0, NOW(), NOW()),
       (4, 4, 0, 0, NOW(), NOW()),
       (5, 5, 0, 0, NOW(), NOW());
