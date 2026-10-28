WITH temp AS (
    SELECT
        p.product_id,
        p.price,
        u.units
    FROM Prices p
    LEFT JOIN UnitsSold u
        ON p.product_id = u.product_id
        AND u.purchase_date BETWEEN p.start_date AND p.end_date
)
SELECT
    product_id,
    ROUND(COALESCE(SUM(price * units) / SUM(units), 0), 2) AS average_price
FROM temp
GROUP BY product_id;