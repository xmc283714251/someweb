<%@page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="sm" uri="/someweb-tags"%>
<sm:view title="开发平台">
<style type="text/css">
	body{
        margin:0;padding:0;border:0;width:100%;height:100%;overflow:hidden;
    }    
    .header
    {
        background:#B5CCE6;
    }
	
</style>
	<div id="layout1" class="mini-layout" style="width:100%;height:100%;">
	    <div class="header" region="north" height="70" showSplit="false" showHeader="false">
	        <h1 style="margin:0;padding:15px;cursor:default;font-family:微软雅黑,黑体,宋体;">熊明春应用开发平台</h1>
	        <div style="position:absolute;top:18px;right:10px;">
	            <a class="mini-button mini-button-iconTop" iconCls="icon-close" onclick="onClick"  plain="true" >退出</a>        
	        </div>
	    </div>
	    <div title="south" region="south" showSplit="false" showHeader="false" height="30" >
	        <div style="line-height:28px;text-align:center;cursor:default">Copyright © 熊明春应用开发平台</div>
	    </div>
	    <div title="center" region="center" style="border:0;" bodyStyle="overflow:hidden;">
	        <!--Splitter-->
	        <div class="mini-splitter" style="width:100%;height:100%;" borderStyle="border:0;">
	            <div size="180" maxSize="250" minSize="100" showCollapseButton="true" style="border:0;">
	                <!--OutlookTree-->
	                <sm:outlooktree id="leftTree" url="/outlooktree.txt" idField="id" textField="text" parentField="pid"/>
	            </div>
	            <div showCollapseButton="false" style="border:0;">
	                <!--Tabs-->
	                <div id="mainTabs" class="mini-tabs" activeIndex="0" style="width:100%;height:100%;" plain="false" onactivechanged="onTabsActiveChanged">
	                    <div title="首页" url="" ></div>
	                </div>
	            </div>        
	        </div>
	    </div>
	</div>
</sm:view>