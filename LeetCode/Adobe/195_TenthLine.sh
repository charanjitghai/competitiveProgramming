# Read from the file file.txt and output the tenth line to stdout.
cnt=0
while read line
do

cnt=$((cnt+1))
if [ $cnt -eq 10 ];
then
    echo $line
fi
done < file.txt