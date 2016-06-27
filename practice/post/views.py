from django.shortcuts import render
from .models import Post
from rest_framework.views import APIView
from rest_framework.response import Response
from .serializers import PostSerializer

# Create your views here.
class PostView(APIView):
    def get(self, request, institute, format=None):
        query_set = Post.objects.filter(institute=institute)
        serializer = PostSerializer(query_set, many=True)
        return Response(serializer.data)

    def post(self, request, format=None):
        serializer = PostSerializer(data=request.data)
        if serializer.is_valid():
            serializer.save()
            return Response(serializer.data, status=status.HTTP_201_CREATED)
        return Response(serializer.errors, status=status.HTTP_400_BAD_REQUEST)
class PostUserView(APIView):
    def get(self, request,user, format=None):
        query_set = Post.objects.filter(user=user)
        serializer = PostSerializer(query_set, many=True)
        return Response(serializer.data) 
