#!/bin/bash
function readDir(){
    for element in `ls $1`
    do
        dir_or_file=$1"/"$element
        if [ -d $dir_or_file ]
        then
            if [ $element = "build" ]
            then
                if [ -f $1"/"build.gradle ];then
                    #read -p "$dir_or_file Confirm delete [Y/N]:" val
                    #if [ $val == 'y' ] || [ $val == 'Y' ]; then
                        rm -rf $dir_or_file
                    #fi
                fi
            else
                readDir $dir_or_file
            fi
        fi
    done
}

CURRENT_DIR=$(cd $(dirname $0); pwd)

readDir $CURRENT_DIR