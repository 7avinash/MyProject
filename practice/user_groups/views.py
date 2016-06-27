from django.shortcuts import render
from .models import UserGroup
from rest_framework.views import APIView
from rest_framework.response import Response
from .serializers import UserGroupSerializer
from rest_framework import status

# Create your views here.

class UserGroupView(APIView):

	def get(self, request, format=None):
		queryset = UserGroup.objects.filter(owner=request.user)
		serializer = UserGroupSerializer(queryset, many=True)
		return Response(serializer.data)

	def post(self, request, format=None):
		serializer = UserGroupSerializer(data=request.data)
		if serializer.is_valid():
			serializer.save()
			return Response(serializer.data, status=status.HTTP_201_CREATED)
		return Response(serializer.errors, status=status.HTTP_400_BAD_REQUEST)
