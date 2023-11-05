select PT_NAME,PT_NO, GEND_CD, AGE, NVL(TLNO, 'NONE') AS TLNO from patient
where age <= 12 and gend_cd = 'W'
order by age desc, pt_name asc