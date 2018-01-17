package com.wtu.acquisition.quartz.init;

import java.io.File;
import java.io.FileFilter;
import java.util.function.Consumer;

import org.apache.commons.io.monitor.FileAlterationListener;
import org.apache.commons.io.monitor.FileAlterationMonitor;
import org.apache.commons.io.monitor.FileAlterationObserver;

public class FileWatcher {
//     private static FileWatcher instance = new FileWatcher();
//     private FileAlterationMonitor monitor = new FileAlterationMonitor(5000);
//     public static FileWatcher.getFileWatcher(){
//    	 return FileWatcher.instance;
//     }
//     private FileWatcher() {
//    	 this.monitor.start();
//     }
//     public void addFileChangeWatcher(String s,boolean casade,Consumer<File> func) {
//    	 File fold = new File(s);
//    	 FileAlterationObserver obser = new FileAlterationObserver(fold, new FileFilter() {
//			
//			@Override
//			public boolean accept(File pathname) {
//				if(casade&&pathname.isDirectory()) {
//					return false;
//				}
//				return true;
//			}
//		});
//    	 obser.addListener(new FileAlterationListener() {
//			
//			
//			
//			@Override
//			public void onFileChange(File file) {
//				super.onFileChange(file);
//				
//			}
//
//			@Override
//			public void onDirectoryChange(File arg0) {
//				// TODO Auto-generated method stub
//				
//			}
//
//			@Override
//			public void onDirectoryCreate(File arg0) {
//				// TODO Auto-generated method stub
//				
//			}
//
//			@Override
//			public void onDirectoryDelete(File arg0) {
//				// TODO Auto-generated method stub
//				
//			}
//
//			@Override
//			public void onFileCreate(File arg0) {
//				// TODO Auto-generated method stub
//				
//			}
//
//			@Override
//			public void onFileDelete(File arg0) {
//				// TODO Auto-generated method stub
//				
//			}
//
//			@Override
//			public void onStart(FileAlterationObserver arg0) {
//				// TODO Auto-generated method stub
//				
//			}
//
//			@Override
//			public void onStop(FileAlterationObserver arg0) {
//				// TODO Auto-generated method stub
//				
//			}
//		
//			
//		
//		});
//    			 
//     }
}

