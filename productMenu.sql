-- 菜单 SQL
insert into sys_menu (menu_name, parent_id, order_num, url, menu_type, visible, perms, icon, create_by, create_time, update_by, update_time, remark)
values('商品管理', '3', '1', '/mall/product', 'C', '0', 'mall:product:view', '#', 'admin', sysdate(), '', null, '商品管理菜单');

-- 按钮父菜单ID
SELECT @parentId := LAST_INSERT_ID();

-- 按钮 SQL
insert into sys_menu (menu_name, parent_id, order_num, url, menu_type, visible, perms, icon, create_by, create_time, update_by, update_time, remark)
values('商品管理查询', @parentId, '1',  '#',  'F', '0', 'mall:product:list',         '#', 'admin', sysdate(), '', null, '');

insert into sys_menu (menu_name, parent_id, order_num, url, menu_type, visible, perms, icon, create_by, create_time, update_by, update_time, remark)
values('商品管理新增', @parentId, '2',  '#',  'F', '0', 'mall:product:add',          '#', 'admin', sysdate(), '', null, '');

insert into sys_menu (menu_name, parent_id, order_num, url, menu_type, visible, perms, icon, create_by, create_time, update_by, update_time, remark)
values('商品管理修改', @parentId, '3',  '#',  'F', '0', 'mall:product:edit',         '#', 'admin', sysdate(), '', null, '');

insert into sys_menu (menu_name, parent_id, order_num, url, menu_type, visible, perms, icon, create_by, create_time, update_by, update_time, remark)
values('商品管理删除', @parentId, '4',  '#',  'F', '0', 'mall:product:remove',       '#', 'admin', sysdate(), '', null, '');

insert into sys_menu (menu_name, parent_id, order_num, url, menu_type, visible, perms, icon, create_by, create_time, update_by, update_time, remark)
values('商品管理导出', @parentId, '5',  '#',  'F', '0', 'mall:product:export',       '#', 'admin', sysdate(), '', null, '');
