#include <stdio.h>  
#include <stdlib.h>  
#include <string.h>  
  
#include <sys/types.h>  
#include <dirent.h>  

#include "consolelog.h"
  
  
/* dir_recursive [���j���˥ؿ��U�Ҧ����] 
* ���� path �U�Ҧ������A�ÿ�X�� output ����� 
* output �������i�g�J����� 
* */  
int dir_recursive(const char *path){  
   //char glue='\\'; // Windows �����j�Ÿ�  
   char glue='/'; // Linux �����j�Ÿ�  
     
   // ���ն}�ҥؿ�  
   DIR * dp = opendir(path);  
     
   if (dp == NULL){      
       // ���O�ؿ��A��X���ɮ�      
          consolelog("dir_recursive: %s\n", path);  
          return 1;  
   }  
     
   struct dirent *filename;      
   while((filename=readdir(dp))){  
       // ���L��e�Υ��ؿ�  
       if(!strcmp(filename->d_name,"..") || !strcmp(filename->d_name,".")){  
           continue;  
       }  
         
       // �p��s�����|�r��һݪ�����  
       int pathLength=strlen(path)+strlen(filename->d_name)+2;  
       // ���ͷs���}�C�Ŷ�  
       char *pathStr = (char*)malloc(sizeof(char) * pathLength);  
       // �ƻs��e�ؿ����|�ܷs���}�C�Ŷ�  
       strcpy(pathStr, path);  
         
       // �ˬd�ؿ����j�Ÿ�  
       int i=strlen(pathStr);  
       if(pathStr[i-1]!=glue){  
           pathStr[i]=glue;  
           pathStr[i+1]='\0';  
       }  
         
       // �걵���ؿ��W�٩��ɮצW�٦ܷs���}�C�Ŷ�  
       strcat(pathStr, filename->d_name);  
         
       // ���j�I�s�ؿ�����  
       dir_recursive(pathStr);  
         
   }  
     
   // �����ؿ�  
   closedir(dp);  
     
   return 1;  
}  
