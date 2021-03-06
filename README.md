# 整体概述

> 用户可通过该app方便地实现座位查看，座位预约，扫码入座，快速离座和学习社区交流等功能

# 功能模块

<li> 登录

<li> 座位查看

<li> 个人入座状态查看

<li> 个人信息查看

<li> 预约座位

<li> 扫码入座

<li> 快速离座

<li> 学习社区交流

## 登录

> 用户可使用自己学校教务系统的账号进行登录，并能同步学生的个人信息

![login](/img/login.PNG)

## 座位查看

> 用户可查看图书管当前座位的情况，包括空闲，已被预约，已被占用和暂离


## 预约座位

> 该功能需要用户在线时长达到50小时才能使用，可提前预定座位，但若在15分钟内没有扫码上座则自动空闲出该座位，并为此用户记过一次（累计3次则取消其预约座位权利）

## 扫码入座

> 扫描座位二维码输入入座时长即可上座，此时座位会转换成占用状态，在座位为占用状态时，为了解决该座位处于占用状态，但又没有人坐问题，允许其它学生扫码改变该座位拥有者（当学生扫码时，会自动发信息给管理员，有管理员判断是否将该座位至于空闲状态）

## 个人入座状态查看

> 用户可通过此功能看到自己的入座累计时长，座位号以及需要离座的时间，并在此实现快速离座与暂时离座功能

### 快速离座

> 此时座位会转换成空闲状态

### 暂时离座

> 需要开启暂时离开座位，但在15分钟内要回到座位并取消暂离状态，否则将此作为自动置为空闲状态，在暂离状态其它学生无权扫码入该座位

## 个人信息查看

> 同步用户教务系统信息，包括姓名，学院，学号，专业，入座次数和在线时长，并从后台数据库拿到用户的昵称和个性签名

![mine](/img/mine.PNG)

## 学习社区交流

**<font size="4sp">帖子交互**

> 可根据对方的隐私和权限设置查看对方信息以及与当前入座学生进行交互

**<li>添加移除好友**

**<li>发送帖子**

用户可设置个人信息（姓名，年级学院，班级专业）的可见性

**<font size="4sp">即时交互**

用户可设置交互权限（无限制，双方为好友）


# UML图

<li> 用例图

<li> 类图

# 详细设计

## 所需要的数据库设计

## 所需要的接口

**<li> 登录接口**

**<li> 查看座位接口**

**<li> 预约座位接口**

**<li> 扫码上座接口**

**<li> 离座接口**

**<li> 查看当前入座信息接口**

## 各功能的实现方式
