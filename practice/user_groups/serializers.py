from .models import UserGroup
from rest_framework import serializers

class UserGroupSerializer(serializers.ModelSerializer):

	class Meta:
		model = UserGroup
		fields = ('name', 'owner', 'members')