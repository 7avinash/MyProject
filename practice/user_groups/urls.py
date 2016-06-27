from django.conf.urls import url, include
from .views import UserGroupView


urlpatterns=[
	url(r'^groups/', UserGroupView.as_view(), name='group')
]